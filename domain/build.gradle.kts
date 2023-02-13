plugins {
    @Suppress("JavaPluginLanguageLevel")
    id("java-library")
    kotlin("jvm")
    id("greeting")
}

dependencies {
    implementation(Dependence.Kotlin.Coroutine.core)
}
