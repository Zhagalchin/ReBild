plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.feature_products_api"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(libs.coroutinesAndroid)
    implementation(libs.javax.inject)
    implementation(libs.roomRuntime)
    implementation(libs.retrofit)
    implementation(libs.okhttp)

    implementation(libs.okhttpLogging)
    implementation(libs.androidx.fragment.ktx)
//    implementation(libs.roomKtx)
    implementation(project(":core-network-api"))
    implementation(project(":core-database-api"))

    ksp(libs.roomCompiler)
}