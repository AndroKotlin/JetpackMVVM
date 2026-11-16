# JetpackMVVM

A modern Android application built using **Kotlin**, **Jetpack Compose (Material 3)**, and the **MVVM (Model-View-ViewModel)** architectural pattern. This project demonstrates a clean separation of concerns between the data model, UI state management, and declarative Compose views.

## Features
* **Clean MVVM Architecture:** Organized into distinct layers (`model_layer`, `view_model_layer`, and `view_layer`) for better scalability, testability, and maintainability.
* **Declarative UI with Jetpack Compose:** Built using Material 3 components, custom typography, color schemes, and theming.
* **Reactive State Management:** Uses `ViewModel` to manage UI-related data in a lifecycle-conscious way and update `UserScreen` reactively.
* **Gradle Version Catalog & Kotlin DSL:** Configured with `.kts` build scripts and `libs.versions.toml` for modern dependency management.

## Tech Stack
* **Language:** Kotlin
* **UI Framework:** Jetpack Compose, Material 3
* **Architecture:** MVVM (Model-View-ViewModel)
* **Build System:** Gradle (Kotlin DSL) & Version Catalog (`libs.versions.toml`)
* **JDK:** Java 17

## Project Structure
```text
JetpackMVVM/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/krypton/jetpackmvvm/
│   │   │   │   ├── model_layer/
│   │   │   │   │   └── User.kt              # Data model (id, name, role)
│   │   │   │   ├── view_model_layer/
│   │   │   │   │   └── UserViewModel.kt     # ViewModel managing UI state & logic
│   │   │   │   ├── view_layer/
│   │   │   │   │   └── UserScreen.kt        # Jetpack Compose UI screen
│   │   │   │   ├── ui/theme/
│   │   │   │   │   ├── Color.kt             # App color palette
│   │   │   │   │   ├── Theme.kt             # Material 3 theme configuration
│   │   │   │   │   └── Type.kt              # Typography definitions
│   │   │   │   └── MainActivity.kt          # Application entry point
│   │   │   ├── res/                         # App resources (drawables, strings, themes)
│   │   │   └── AndroidManifest.xml
│   │   ├── test/                            # Local unit tests
│   │   └── androidTest/                     # Instrumented UI tests
│   └── build.gradle.kts
├── gradle/
│   └── libs.versions.toml                   # Centralized dependency versions
├── build.gradle.kts
└── settings.gradle.kts
