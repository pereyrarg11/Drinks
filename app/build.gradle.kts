import com.google.firebase.appdistribution.gradle.firebaseAppDistribution
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    // Google services Gradle plugin
    id("com.google.gms.google-services")
    // App Distribution Gradle plugin
    id("com.google.firebase.appdistribution")
    // Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics")
    // Detekt
    id("io.gitlab.arturbosch.detekt")
}

android {
    buildFeatures {
        buildConfig = true
    }
    signingConfigs {
        getByName("debug") {
            val signingProperties = getSigningPropertiesByFlavorName(this.name)
            storePassword = signingProperties.getProperty("STORE_PASSWORD")
            keyPassword = signingProperties.getProperty("KEY_PASSWORD")
            keyAlias = signingProperties.getProperty("KEY_ALIAS")
            storeFile = file(signingProperties.getProperty("STORE_FILE_PATH"))
        }
        create("release") {
            val releaseSigningProperties = getSigningPropertiesByFlavorName(this.name)
            storePassword = releaseSigningProperties.getProperty("STORE_PASSWORD")
            keyPassword = releaseSigningProperties.getProperty("KEY_PASSWORD")
            keyAlias = releaseSigningProperties.getProperty("KEY_ALIAS")
            storeFile = file(releaseSigningProperties.getProperty("STORE_FILE_PATH"))
        }
    }

    namespace = "com.pereyrarg11.drinks"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pereyrarg11.drinks"
        minSdk = 24
        targetSdk = 34
        // 1_0001_2_3
        // Major Minor  Patch  Release candidate
        // 1     0001   2      3
        versionCode = 1_0000_0_1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        firebaseAppDistribution {
            artifactType = "APK"
            serviceCredentialsFile = "secrets/google-service-account/drinks-55968-bdbeabcf946b.json"
            // groups, testers and releaseNotes SHOULD be added on gradle command execution
        }

        val (apiKey, apiVersion) = try {
            val apiProps = loadPropertiesFile("secrets/cocktail-api/api.properties")
            // paid version values
            arrayOf(
                apiProps.getProperty("API_KEY"),
                apiProps.getProperty("API_VERSION")
            )
        } catch (e: Exception) {
            logger.error("${e.message}\nFree API values will be used instead!")
            // free version values
            arrayOf("1", "v1")
        }
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
        buildConfigField("String", "API_VERSION", "\"$apiVersion\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // TODO: sort dependencies by functionality
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    /* Jetpack Compose */
    // Glide
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")
    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    // Icons
    implementation("androidx.compose.material:material-icons-extended")

    /* Dependency Injection */
    // Dagger Hilt
    // TODO: set version as constant
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    /* Remote data */
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Sandwich
    implementation("com.github.skydoves:sandwich-retrofit:2.0.0")

    /* Firebase */
    // BoM
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    // Analytics
    implementation("com.google.firebase:firebase-analytics")
    // Crashlytics
    implementation("com.google.firebase:firebase-crashlytics")
}

detekt {
    // TODO: set Detekt version as constant in buildSrc
    toolVersion = "1.23.3"
    config.setFrom(file("../config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
}

fun getSigningPropertiesByFlavorName(flavorName: String): Properties {
    try {
        return loadPropertiesFile("signing/$flavorName/signing.properties")
    } catch (exception: Exception) {
        throw Exception("Signing has not been configured for \"$flavorName\".\n${exception.message}")
    }
}

@Throws(Exception::class)
fun loadPropertiesFile(rootPath: String): Properties {
    val propertiesFile = rootProject.file(rootPath)
    val properties = Properties()
    properties.load(FileInputStream(propertiesFile))
    return properties
}
