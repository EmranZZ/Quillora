plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt.android)
    kotlin("kapt")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.jetpackcompose"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.jetpackcompose"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(libs.androidx.navigation.compose) //navigation
    implementation(libs.androidx.compose.material.icons.extended) //for more icons
    implementation(libs.androidx.lifecycle.viewmodel.compose) //viewModel
    implementation(libs.androidx.constraintlayout.compose) //constraint layout
    implementation(libs.accompanist.permissions) //permission
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.compose.runtime) //runtime compose

    implementation(libs.retrofit) //retrofit
    implementation(libs.converter.gson)

    implementation(libs.hilt.android) // Hilt
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose) // // Hilt + Navigation (Compose)
    implementation(libs.coil)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.toolbar.compose)
    implementation(libs.androidx.compose.runtime.livedata) //liveData runtime library
    implementation(libs.androidx.paging.compose) // pagination dependency


    // Room Database
    implementation(libs.androidx.room.runtime) // core room library
    implementation(libs.androidx.room.ktx)     // kotlin helper (coroutine support)
    kapt(libs.androidx.room.compiler)

}
