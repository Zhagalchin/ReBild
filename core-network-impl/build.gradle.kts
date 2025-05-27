plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    kotlin("kapt")

}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
dependencies {
    // Зависимость на API-модуль
    implementation(project(":core-network-api"))

    // Dagger 2
    implementation(libs.daggerAndroid)
    kapt(libs.daggerCompiler)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofitGson)
    implementation(libs.retrofitCoroutinesAdapter) // Не runtimeOnly!

    // OkHttp
    implementation(libs.okhttp)
    implementation(libs.okhttpLogging)

    // Coroutines
    implementation(libs.coroutinesAndroid)


}