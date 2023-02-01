package utils

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.handleDependencies(config: DependenciesConfig) = with(config) {

    implementations.forEach {
        add("implementation", it)
    }

    debugImplementations.forEach {
        add("debugImplementation", it)
    }

    testImplementations.forEach {
        add("testImplementation", it)
    }

    androidTestImplementations.forEach {
        add("androidTestImplementation", it)
    }

    kapts.forEach {
        add("kapt", it)
    }

    kaptTests.forEach {
        add("kaptTest", it)
    }

    kaptAndroidTests.forEach {
        add("kaptAndroidTest", it)
    }
}
