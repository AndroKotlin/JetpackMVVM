package com.krypton.jetpackmvvm.view_model_layer

import androidx.lifecycle.ViewModel
import com.krypton.jetpackmvvm.model_layer.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel: ViewModel() {

    // Backing property to maintain a private mutable state flow
    private  val _userList = MutableStateFlow<List<User>>(
        listOf(
            User(1,"Mahesh","Senior Android Developer"),
            User(2,"Manas","Senior Android Developer"),
            User(3,"Waman","Senior Android Developer"),
            User(4,"Adarsh","Senior Android Developer"),
        )
    )

    // Read-only state flow exposed to the UI (View layer)
    val userList: StateFlow<List<User>> = _userList.asStateFlow()
    // Example of handling business logic / actions inside the ViewModel
    fun onUserClicked(user: User){
        // Handle click event actions, analytics, or state modifications here
    }
}