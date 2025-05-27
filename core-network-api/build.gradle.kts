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
    implementation(libs.retrofit)
    implementation(libs.okhttp)

    implementation(libs.okhttpLogging)
    implementation(libs.serializationJson)
    kapt(libs.daggerCompiler)
    compileOnly(libs.daggerAndroid)
    // Dagger 2 (только аннотации, без реализации)
}