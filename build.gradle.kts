// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    // Google services Gradle plugin
    id("com.google.gms.google-services") version "4.4.0" apply false
    // App Distribution Gradle plugin
    id("com.google.firebase.appdistribution") version "4.0.1" apply false
    // Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics") version "2.9.9" apply false
}