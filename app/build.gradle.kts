plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "${Version.Android.bundleId}.android"

    defaultConfig {
        applicationId = "${Version.Android.bundleId}.android"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependence.Kotlin.Coroutine.android)

    implementation(Dependence.Android.Core.core)
    implementation(Dependence.Android.Core.appcompat)
    implementation(Dependence.Android.Core.material)

    implementation(Dependence.Android.Lifecycle.runtime)

    implementation(Dependence.Android.Compose.activity)

    implementation(Dependence.Android.Compose.ui)
    debugImplementation(Dependence.Android.Compose.tooling)
    implementation(Dependence.Android.Compose.toolingPreview)
    implementation(Dependence.Android.Compose.foundation)
    implementation(Dependence.Android.Compose.material)
}
