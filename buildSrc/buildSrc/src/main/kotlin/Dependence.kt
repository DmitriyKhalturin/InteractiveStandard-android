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

    /**
     * Use Material 2. Read for migration to Material 3 (https://developer.android.com/jetpack/compose/designsystems/material2-material3).
     */
    object Compose {
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:${Version.compose}"

        private const val version = Version.compose
        private const val foundationVersion = "1.3.1"
        private const val navigationVersion = "2.5.3"

        const val ui = "androidx.compose.ui:ui:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val foundation = "androidx.compose.foundation:foundation:$foundationVersion"
        const val material = "androidx.compose.material:material:$foundationVersion"
        const val icons = "androidx.compose.material:material-icons-core:$foundationVersion"
        const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:${Version.gradle}"
        const val desugaringJdk = "com.android.tools:desugar_jdk_libs:1.1.5"

        object CoreDesugaring {
            private const val version = "1.1.5"
            const val congigurationName = "coreLibraryDesugaring"
            const val dependencyNotation = "com.android.tools:desugar_jdk_libs:$version"
        }

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
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val viewmodelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

        object Compose {
            private const val version = "1.6.1"
            const val activity = "androidx.activity:activity-compose:$version"
        }

        object Accompanist {
            private const val version = "0.28.0"

            const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:$version"
            const val pager = "com.google.accompanist:accompanist-pager:$version"
        }
    }

    object Koin {
        private const val coreVersion = "3.3.2"
        private const val androidVersion = "3.3.2"
        private const val composeVersion = "3.4.1"
        private const val ktorVersion = "3.3.0"

        const val core = "io.insert-koin:koin-core:$coreVersion"
        const val android = "io.insert-koin:koin-android:$androidVersion"
        const val androidCompat = "io.insert-koin:koin-android-compat:$androidVersion"
        const val androidWorkmanager = "io.insert-koin:koin-androidx-workmanager:$androidVersion"
        const val androidNavigation = "io.insert-koin:koin-androidx-navigation:$androidVersion"
        const val compose = "io.insert-koin:koin-androidx-compose:$composeVersion"
        const val ktor = "io.insert-koin:koin-ktor:$ktorVersion"
        const val logger = "io.insert-koin:koin-logger-slf4j:$ktorVersion"
    }

    object Hilt {
        private const val version = "2.44.2"
        private const val composeNavigationVersion = "1.0.0"

        const val kapt = "com.google.dagger:hilt-compiler:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val composeNavigation = "androidx.hilt:hilt-navigation-compose:$composeNavigationVersion"
    }

    object OkHttp {
        private const val version = "4.10.0"

        const val core = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val converterScalars = "com.squareup.retrofit2:converter-scalars:$version"
    }

    object Ktor {
        private const val version = "2.2.2"
        const val core = "io.ktor:ktor-client-core:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
    }

    object Slf4j {
        private const val version = "2.0.6"

        const val api = "org.slf4j:slf4j-simple:$version"
        const val simple = "org.slf4j:slf4j-simple:$version"
    }

    object Log4j {
        private const val version = "2.17.2"

        const val core = "org.apache.logging.log4j:log4j-core:$version"
        const val impl = "org.apache.logging.log4j:log4j-slf4j-impl:$version"
    }

    object Logback {
        private const val version = "1.4.5"

        const val classic = "ch.qos.logback:logback-classic:$version"
    }

    object Timber {
        private const val version = "5.0.1"

        const val core = "com.jakewharton.timber:timber:$version"
    }

    object Room {
        private const val version = "2.5.0"

        const val kapt = "androidx.room:room-compiler:$version"

        const val core = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:$version"
    }

    object SQLDelight {
        private const val version = "1.5.5"

        const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:$version"

        const val core = "com.squareup.sqldelight:runtime:$version"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
    }

    object Coil {
        private const val version = "2.2.2"
        const val core = "io.coil-kt:coil:$version"
        const val compose = "io.coil-kt:coil-compose:$version"
        const val gif = "io.coil-kt:coil-gif:$version"
        const val svg = "io.coil-kt:coil-svg:$version"
        const val video = "io.coil-kt:coil-video:$version"
    }
}
