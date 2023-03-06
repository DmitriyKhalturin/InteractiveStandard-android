import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import GreetingConfig.Companion.getGreetingConfig

class GreetingPlugin : Plugin<Project> {

    companion object {

        private val Project.isApplicationModule: Boolean
            get() = this is com.android.build.gradle.AppExtension

        private fun Project.android(action: BaseExtension.() -> Unit) {
            (extensions.findByName("android") as? BaseExtension)?.run(action)
        }

        private fun Project.java(action: JavaPluginExtension.() -> Unit) {
            (extensions.findByName("java") as? JavaPluginExtension)?.run(action)
        }
    }

    private val javaVersion = JavaVersion.VERSION_1_8 // TODO: place to config.

    override fun apply(target: Project) {
        with(target) {
            repositories {
                google()
                mavenCentral()
                maven("https://jitpack.io")
            }

            tasks.withType(KotlinCompile::class.java) {
                kotlinOptions {
                    jvmTarget = "$javaVersion"

                    freeCompilerArgs = listOf("-Xcontext-receivers")
                }
            }

            val greetingConfig = getGreetingConfig()

            android {
                plugins.apply("kotlin-android")

                setCompileSdkVersion(greetingConfig.compileSdk)

                defaultConfig {
                    minSdk = greetingConfig.minSdk
                    targetSdk = greetingConfig.compileSdk

                    if (isApplicationModule) {
                        versionCode = greetingConfig.versionCode
                        versionName = greetingConfig.versionName
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

                    sourceCompatibility = javaVersion
                    targetCompatibility = javaVersion
                }

                val dependencies = properties["dependencies"]

                (dependencies as DependencyHandler).apply {
                    add(Dependence.Android.CoreDesugaring.congigurationName, Dependence.Android.CoreDesugaring.dependencyNotation)
                }
            }

            java {
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }
        }
    }
}
