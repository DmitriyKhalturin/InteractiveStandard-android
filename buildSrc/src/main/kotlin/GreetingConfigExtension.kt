import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

open class GreetingConfigExtension(project: Project) {

    private val objects = project.objects

    private val compileSdkProperty: Property<Int> = objects.property()
    private val minSdkProperty: Property<Int> = objects.property()

    private val bundleIdProperty: Property<String> = objects.property()

    private val versionCodeProperty: Property<Int> = objects.property()
    private val versionNameProperty: Property<String> = objects.property()

    var compileSdk: Int
        get() = compileSdkProperty.get()
        set(value) = compileSdkProperty.set(value)

    var minSdk: Int
        get() = minSdkProperty.get()
        set(value) = minSdkProperty.set(value)

    var bundleId: String
        get() = bundleIdProperty.get()
        set(value) = bundleIdProperty.set(value)

    var versionCode: Int
        get() = versionCodeProperty.get()
        set(value) = versionCodeProperty.set(value)

    var versionName: String
        get() = versionNameProperty.get()
        set(value) = versionNameProperty.set(value)
}
