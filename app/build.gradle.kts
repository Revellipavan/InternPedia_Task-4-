@file:Suppress("UNUSED_EXPRESSION", "DEPRECATION")

import com.android.build.gradle.internal.dsl.LintOptions

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.wakeupbuddy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wakeupbuddy"
        minSdk = 24
        //noinspection OldTargetApi
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // Specify the lint options
    fun LintOptions.() {
        warning("deprecation")
    }

    // Add the Java compile options to enable lint warnings for deprecated APIs
    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-Xlint:deprecation")
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}