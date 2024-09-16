plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    kotlin("kapt")
    id("kotlin-parcelize")
    alias(libs.plugins.safeArgs)
}

android {
    namespace = "com.example.nasa_api_astoried_radar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nasa_api_astoried_radar"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    dataBinding {
        enable= true
    }
}

dependencies {

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

    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.converter)
    implementation(libs.room)
    implementation(libs.room.coroutines)
    kapt("androidx.room:room-compiler:2.6.1")
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.work)
    implementation(libs.timber)
    implementation(libs.picasso)
    implementation(libs.retrofit)
    implementation(libs.retrofit.scalars)
    implementation("com.github.bumptech.glide:glide:4.16.0")


 //   implementation(libs.imageSlideshow)

  //  annotationProcessor(libs.glideCompiler)
}