pluginManagement {
    repositories {
        google() // Google's repository for Android plugins
        mavenCentral() // Maven Central repository for additional dependencies
        gradlePluginPortal() // Gradle Plugin Portal for Kotlin and other plugins
    }

    // Optional: Define plugins if needed
    plugins {
        id("org.jetbrains.kotlin.android") version "1.9.0" // Ensure the correct Kotlin plugin version
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Google's repository for Android dependencies
        mavenCentral() // Maven Central repository
    }
}

rootProject.name = "MyCircle"
include(":app")
