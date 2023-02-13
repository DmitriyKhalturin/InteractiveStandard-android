plugins {
    id("greetingConfig")
}

greetingConfig {
    compileSdk = 33
    minSdk = 24

    bundleId = "com.interactivestandard"

    versionCode = 1
    versionName = "1.0"
}

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

tasks.create<Delete>("clean") {
    delete = setOf(
        rootProject.buildDir.absolutePath
    )
}
