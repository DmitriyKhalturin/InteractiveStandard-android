import org.gradle.api.Project

data class GreetingConfig(
    val compileSdk: Int,
    val minSdk: Int,
    val bundleId: String,
    val versionCode: Int,
    val versionName: String,
) {
    companion object {
        private const val key = "greetingConfig"

        fun Project.saveToGreetinConfig(extension: GreetingConfigExtension) {
            val config = with(extension) {
                GreetingConfig(compileSdk, minSdk, bundleId, versionCode, versionName)
            }

            extensions.extraProperties.set(key, config)
        }

        fun Project.getGreetingConfig(): GreetingConfig {
            return properties[key] as GreetingConfig
        }

        val Project.bundleId: String
            get() = (properties[key] as GreetingConfig).bundleId
    }
}
