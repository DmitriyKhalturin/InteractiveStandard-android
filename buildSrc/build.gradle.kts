plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:${Version.gradle}")
    implementation(kotlin("gradle-plugin", Version.kotlin))
}

kotlin {
    sourceSets
        .getByName("main")
        .kotlin
        .srcDirs("buildSrc/src/main/kotlin")
}

gradlePlugin {
    plugins {
        register("GreetingConfigPlugin") {
            id = "greetingConfig"
            implementationClass = "GreetingConfigPlugin"
        }

        register("GreetingPlugin") {
            id = "greeting"
            implementationClass = "GreetingPlugin"
        }
    }
}
