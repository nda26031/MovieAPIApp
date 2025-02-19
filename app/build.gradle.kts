import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    kotlin("plugin.serialization") version "1.9.24"
}

android {
    namespace = "com.example.movieapiapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.movieapiapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    dependencies {

        // Views/Fragments navigation
        implementation("androidx.navigation:navigation-fragment:2.8.6")
        implementation("androidx.navigation:navigation-ui:2.8.6")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        // Retrofit with Scalar Converter
        implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        implementation("com.github.bumptech.glide:glide:4.12.0")
        annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")


        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
}