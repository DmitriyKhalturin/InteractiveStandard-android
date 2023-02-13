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
