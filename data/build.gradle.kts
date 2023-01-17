plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "${Version.Android.bundleId}.data"
}

dependencies {
    implementation(Dependence.Android.Core.core)

    implementation(Dependence.Kotlin.Coroutine.android)
}
