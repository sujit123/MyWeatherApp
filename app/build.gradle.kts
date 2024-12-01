plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.myweatherapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myweatherapp"
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
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    //retrofit
    implementation(libs.retrofit)
    implementation (libs.converter.gson)
    // coroutine
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    //glide
    implementation(libs.glide)
    annotationProcessor(libs.compiler)
    //Test Dependencies
    testImplementation(libs.junit)
    testImplementation(libs.truth)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation (libs.androidx.rules)
    androidTestImplementation (libs.androidx.runner)
    androidTestImplementation(libs.mockito.android)
    androidTestImplementation(libs.androidx.espresso.intents)
    androidTestImplementation(libs.androidx.espresso.contrib)
    implementation (libs.mockito.core)
    implementation (libs.mockito.inline)
    testImplementation(libs.mockito.core.v521)
    testImplementation(libs.mockito.kotlin)
}