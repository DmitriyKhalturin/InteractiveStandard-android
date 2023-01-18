plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "${Version.Android.bundleId}.data"
}

dependencies {
    implementation(Dependence.Kotlin.Coroutine.android)
    implementation(Dependence.Android.Core.core)
}
