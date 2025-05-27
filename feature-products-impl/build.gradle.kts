plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")

}

android {
    namespace = "com.example.feature_products_impl"
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit.v115)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    implementation(libs.daggerAndroid)
    kapt(libs.daggerCompiler)


    implementation(libs.lifecycleViewModel)

    implementation(libs.lifecycleLiveData)
    implementation(libs.lifecycleRuntime)

    implementation(libs.retrofit)
    implementation(libs.okhttp)

    implementation(libs.okhttpLogging)
    implementation(libs.swiperefreshlayout)
    implementation(libs.glide)
    implementation(project(":core-common"))
    implementation(project(":feature-products-api"))
    implementation(project(":core-network-api"))
    implementation(project(":core-database-api"))
}