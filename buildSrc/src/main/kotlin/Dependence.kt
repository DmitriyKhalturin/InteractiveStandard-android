object Dependence {

    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"

        object Serialization {
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:${Version.kotlin}"

            private const val version = "1.4.1"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }

        object DateTime {
            private const val version = "0.4.0"
            const val kotlinxDateTime = "org.jetbrains.kotlinx:kotlinx-datetime:$version"
        }

        object Coroutine {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object Compose {
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:${Version.compose}"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:${Version.gradle}"

        object Core {
            private const val coreVersion = "1.9.0"
            private const val appcompatVersion = "1.6.0"
            private const val materialVersion = "1.7.0"

            const val core = "androidx.core:core-ktx:$coreVersion"
            const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
            const val material = "com.google.android.material:material:$materialVersion"
        }

        object Lifecycle {
            private const val version = "2.5.1"

            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewmodelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

        object Compose {
            private const val version = Version.compose
            const val ui = "androidx.compose.ui:ui:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val icons = "androidx.compose.material:material-icons-core:$version"

            private const val activityCompose = "1.6.1"
            const val activity = "androidx.activity:activity-compose:$activityCompose"
        }
    }

    object Koin {
        private const val coreVersion = "3.2.2"
        private const val androidVersion = "3.3.0"
        private const val composeVersion = "3.3.0"
        private const val ktorVersion = "3.2.2"

        const val core = "io.insert-koin:koin-core:$coreVersion"
        const val android = "io.insert-koin:koin-android:$androidVersion"
        const val androidCompat = "io.insert-koin:koin-android-compat:$androidVersion"
        const val androidWorkmanager = "io.insert-koin:koin-android-workmanager:$androidVersion"
        const val androidNavigation = "io.insert-koin:koin-android-navigation:$androidVersion"
        const val compose = "io.insert-koin:koin-androidx-compose:$composeVersion"
        const val ktor = "io.insert-koin:koin-ktor:$ktorVersion"
        const val logger = "io.insert-koin:koin-logger-slf4j:$ktorVersion"
    }

    object Ktor {
        private const val version = "2.1.3"
        const val core = "io.ktor:ktor-client-core:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
    }

    object SQLDelight {
        private const val version = "1.5.3"
        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"
        const val core = "com.squareup.sqldelight:runtime:$version"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
    }

    object Coil {
        private const val version = "2.2.2"
        const val core = "io.coil-kt:coil:$version"
        const val compose = "io.coil-kt:coil-compose:$version"
    }
}
