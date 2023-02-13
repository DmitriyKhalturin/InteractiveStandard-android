plugins {
    id("java-library")
    id("greeting")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Dependence.Kotlin.Coroutine.core)
}
