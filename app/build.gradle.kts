@file:Suppress("ExpiredTargetSdkVersion", "OldTargetSdkVersion")

plugins {
    id("com.android.application")
}

android {
    namespace = "com.sac.scribelate"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.sac.scribelate"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0.0"
    }

    signingConfigs {
        create("release") {
            val envKeystorePath = System.getenv("KEYSTORE_FILE")
            val keystoreFile = if (!envKeystorePath.isNullOrEmpty()) {
                val f = file(envKeystorePath)
                if (f.isAbsolute) f else rootProject.file(envKeystorePath)
            } else {
                rootProject.file("release.keystore")
            }

            if (keystoreFile.exists()) {
                storeFile = keystoreFile
                storePassword = System.getenv("KEYSTORE_PASSWORD")
                keyAlias = System.getenv("KEY_ALIAS")
                keyPassword = System.getenv("KEY_PASSWORD")
            } else {
                val debugConfig = signingConfigs.getByName("debug")
                if (debugConfig.storeFile?.exists() == true) {
                    storeFile = debugConfig.storeFile
                    storePassword = debugConfig.storePassword
                    keyAlias = debugConfig.keyAlias
                    keyPassword = debugConfig.keyPassword
                }
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true

            val releaseConfig = signingConfigs.getByName("release")
            signingConfig = if (releaseConfig.storeFile != null) {
                releaseConfig
            } else {
                signingConfigs.getByName("debug")
            }

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lint {
        disable += "OldTargetSdkVersion"
        disable += "TargetSdkVersion"
        ignoreWarnings = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.19.1")
    implementation("androidx.appcompat:appcompat:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.11.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.11.0")

    implementation("androidx.activity:activity-ktx:1.13.0")

    // OkHttp for the ElevenLabs and Google Translate API calls
    implementation("com.squareup.okhttp3:okhttp:5.5.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")

    // Google Material 3
    implementation("com.google.android.material:material:1.14.0")
}
