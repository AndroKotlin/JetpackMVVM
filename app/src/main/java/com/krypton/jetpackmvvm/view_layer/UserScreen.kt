package com.krypton.jetpackmvvm.view_layer


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// **महत्त्वाचे:** हा इम्पोर्ट असणे अत्यंत गरजेचे आहे
import androidx.lifecycle.viewmodel.compose.viewModel

import com.krypton.jetpackmvvm.model_layer.User
import com.krypton.jetpackmvvm.view_model_layer.UserViewModel

@OptIn(ExperimentalMaterial3Api::class) // TopAppBar साठी Material 3 चा हा एनोटेशन कधीकधी लागतो
@Composable
// Previews किंवा Testing सोपे जावे म्हणून viewmodel ला default value दिली आहे
fun UserScreen(viewModel: UserViewModel = viewModel()) {
    val context = LocalContext.current

    // ViewModel मधील StateFlow ला collectAsState ने वाचले
    val userList by viewModel.userList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Team Members") },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Menu clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Search clicked", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = userList,
                key = { user -> user.id }
            ) { user ->
                UserCard(user = user) { clickedUser ->
                    // Interaction ViewModel कडे पाठवली
                    viewModel.onUserClicked(clickedUser)
                    Toast.makeText(context, "Clicked: ${clickedUser.name}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun UserCard(user: User, onItemClick: (User) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(user) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = user.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = user.role,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    MaterialTheme {
        UserScreen()
    }
}