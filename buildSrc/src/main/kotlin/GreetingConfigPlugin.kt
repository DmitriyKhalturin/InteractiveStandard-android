import GreetingConfig.Companion.saveToGreetinConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class GreetingConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create<GreetingConfigExtension>("greetingConfig", target)

        target.afterEvaluate {
            saveToGreetinConfig(extension)
        }
    }
}
