plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)

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
dependencies{
    implementation(libs.coroutinesAndroid)
    implementation(libs.javax.inject)
    implementation(libs.roomRuntime)
    implementation(libs.retrofit)
    implementation(libs.okhttp)

    implementation(libs.okhttpLogging)

//    implementation(libs.roomKtx)
    implementation(project(":core-network-api"))
    implementation(project(":core-database-api"))

    ksp(libs.roomCompiler)
}