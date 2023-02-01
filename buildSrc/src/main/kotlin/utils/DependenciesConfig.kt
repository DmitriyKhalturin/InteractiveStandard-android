package utils

class DependenciesConfig(init: DependenciesConfig.() -> Unit) {

    val implementations = mutableListOf<String>()
    val debugImplementations = mutableListOf<String>()
    val testImplementations = mutableListOf<String>()
    val androidTestImplementations = mutableListOf<String>()
    val kapts = mutableListOf<String>()
    val kaptTests = mutableListOf<String>()
    val kaptAndroidTests = mutableListOf<String>()

    fun implementation(value: String) {
        implementations.add(value)
    }

    fun debugImplementation(value: String) {
        debugImplementations.add(value)
    }

    fun testImplementation(value: String) {
        testImplementations.add(value)
    }

    fun androidTestImplementation(value: String) {
        androidTestImplementations.add(value)
    }

    fun kapt(value: String) {
        kapts.add(value)
    }

    fun kaptTest(value: String) {
        kaptTests.add(value)
    }

    fun kaptAndroidTest(value: String) {
        kaptAndroidTests.add(value)
    }

    init {
        init()
    }
}
