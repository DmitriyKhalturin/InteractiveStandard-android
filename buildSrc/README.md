# buildSrc (prepared gradle scripts)

## Usage

Clone `buildSrc` to your project. Apply `greetingConfig` plugin in your root `gradle.build.kts` and configuration `greeting` plugin:

```kotlin
greetingConfig {
    compileSdk = 33
    minSdk = 23

    bundleId = "com.example"

    versionCode = 1
    versionName = "1.0.0"
}
```

Apply `greeting` plugin in to modules your project to clean up typical gradle configurations.
