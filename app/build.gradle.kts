plugins {
    id("com.android.application")
    kotlin("android")
}

@Suppress("UnstableApiUsage")
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

    implementation(Dependence.Compose.ui)
    debugImplementation(Dependence.Compose.tooling)
    implementation(Dependence.Compose.toolingPreview)
    implementation(Dependence.Compose.foundation)
    implementation(Dependence.Compose.material)

    implementation(Dependence.Koin.core)
    implementation(Dependence.Koin.android)
    implementation(Dependence.Koin.compose)

    implementation(project(":data"))
    implementation(project(":domain"))
}
