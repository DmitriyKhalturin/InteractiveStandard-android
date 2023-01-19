plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
}

android {
    namespace = "${Version.Android.bundleId}.data"
}

dependencies {
    implementation(Dependence.Kotlin.Coroutine.android)

    implementation(Dependence.Android.Core.core)

    implementation(Dependence.Ktor.android)
    implementation(Dependence.Ktor.okhttp)
    implementation(Dependence.Ktor.contentNegotiation)
    implementation(Dependence.Ktor.serialization)
    implementation(Dependence.Ktor.logging)

    implementation(Dependence.Kotlin.Serialization.json)

    implementation(project(":domain"))
}
