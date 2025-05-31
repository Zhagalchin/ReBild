plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.rebild"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rebild"
        minSdk = 24
        targetSdk = 35
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
}

dependencies {
    // Android UI
    implementation(libs.material)
    implementation(libs.swiperefreshlayout)
    implementation(libs.glide)

    // Kotlin Coroutines
    implementation(libs.coroutinesAndroid)

    // Networking: Retrofit & OkHttp
    implementation(libs.retrofit)
    implementation(libs.retrofitGson)
    runtimeOnly(libs.retrofitCoroutinesAdapter)
    implementation(libs.okhttp)
    implementation(libs.okhttpLogging)

    // JSON Serialization
    implementation(libs.serializationJson)

    // DI — Dagger 2
    implementation(libs.dagger)
    implementation(libs.daggerAndroid)
    implementation(libs.daggerAndroidSupport)
    kapt(libs.daggerCompiler)
    kapt(libs.daggerAndroidProcessor)

    // AndroidX Lifecycle (ViewModel, LiveData, Runtime)
    implementation(libs.lifecycleViewModel)
    implementation(libs.lifecycleLiveData)
    implementation(libs.lifecycleRuntime)

    // Room Database
    implementation(libs.roomRuntime)
    implementation(libs.roomKtx)
    ksp(libs.roomCompiler)

    // Core modules
    implementation(project(":core-network-api"))
    implementation(project(":core-network-impl"))
    implementation(project(":core-database-api"))
    implementation(project(":core-database-impl"))
    implementation(project(":core-common"))

}