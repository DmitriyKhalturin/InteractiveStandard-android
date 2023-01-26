buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Version.gradle}")
        classpath(kotlin("gradle-plugin", Version.kotlin))
        classpath(kotlin("serialization", Version.kotlin))
    }
}

subprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"

                freeCompilerArgs = listOf("-Xcontext-receivers")
            }
        }
    }

    afterEvaluate {
        val android = properties["android"]
        val dependencies = properties["dependencies"]

        (android as? com.android.build.gradle.BaseExtension)?.apply {
            val isApplicationModule = android is com.android.build.gradle.AppExtension

            setCompileSdkVersion(Version.Android.targetSdk)

            defaultConfig {
                minSdk = Version.Android.minSdk
                targetSdk = Version.Android.targetSdk

                if (isApplicationModule) {
                    versionCode = Version.Android.versionCode
                    versionName = Version.Android.versionName
                }

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = true
                    if (isApplicationModule) {
                        isShrinkResources = true
                    }
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                }
            }

            compileOptions {
                isCoreLibraryDesugaringEnabled = true

                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

            (dependencies as DependencyHandler).apply {
                add("coreLibraryDesugaring", "com.android.tools:desugar_jdk_libs:${Version.desugarJdk}")
            }
        }
    }
}

tasks.create<Delete>("clean") {
    delete = setOf(
        rootProject.buildDir.absolutePath
    )
}
