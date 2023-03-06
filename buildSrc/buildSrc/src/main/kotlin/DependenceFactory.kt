import org.gradle.api.artifacts.dsl.DependencyHandler

class DependenceFactory private constructor() {
    
    companion object {

        fun dependenceFactory(factory: DependenceFactory.() -> Unit): DependenceFactory {
            return DependenceFactory().apply(factory)
        }

        fun DependencyHandler.inject(config: DependenceFactory) = with(config) {

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
    }

    internal val implementations = mutableListOf<String>()
    internal val debugImplementations = mutableListOf<String>()
    internal val testImplementations = mutableListOf<String>()
    internal val androidTestImplementations = mutableListOf<String>()
    internal val kapts = mutableListOf<String>()
    internal val kaptTests = mutableListOf<String>()
    internal val kaptAndroidTests = mutableListOf<String>()

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
}
