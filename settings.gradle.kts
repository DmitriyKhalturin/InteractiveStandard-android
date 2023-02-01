pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "InteractiveStandard"

val bundleId: String by settings

include(":app")
include(":data")
include(":domain")
