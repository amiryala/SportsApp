# SportsApp

A modern Android application that displays sports leagues and their teams using data from The Sports DB API. This app is built with Kotlin and Jetpack Compose, following modern Android development best practices.

## Features

- View a list of sports leagues from around the world
- Tap on a league to see the teams that participate in it
- Modern, animated UI with Material 3 design
- Offline capability with local caching (data refreshes weekly)
- Clean architecture pattern for scalability and maintainability

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM + Clean Architecture
- **Dependency Injection**: Hilt
- **Networking**: Retrofit
- **Local Storage**: Room
- **Animation**: Compose animations
- **Design**: Material 3

## Architecture

The app follows the Clean Architecture pattern with three main layers:

1. **Presentation Layer**: Contains UI components and ViewModels
- Composable UI components
- ViewModels that expose UI state as StateFlow

2. **Domain Layer**: Contains business logic
- Use cases for different operations
- Repository interfaces
- Domain models

3. **Data Layer**: Handles data access
- Remote data source (API)
- Local data source (Room database)
- Repository implementations

## Dependency Injection

Hilt is used for dependency injection to provide:
- Repository instances
- Use cases
- ViewModels
- Database and DAO instances
- API service

## Caching Strategy

The app implements an efficient caching mechanism that:
- Stores league and team data locally using Room
- Refreshes data from the network only when needed (weekly)
- Provides a smooth offline experience

## Screenshots

[Screenshots would be inserted here]

## Building and Running

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Run on an emulator or physical device

## License

This project is licensed under the MIT License - see the LICENSE file for details.