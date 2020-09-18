const val kotlinVersion = "1.4.10"
const val hiltVersion = "2.29.1-alpha"
const val wireVersion = "3.3.0"

object BuildPlugins {
    object Version {
        const val androidBuildToolsVersion = "4.2.0-alpha11"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Version.androidBuildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltAndroidPlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
    const val wirePlugin = "com.squareup.wire:wire-gradle-plugin:$wireVersion"

    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
    const val versions = "com.github.ben-manes.versions"
}

object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}


object Libraries {
    private object Versions {
        const val appCompat = "1.3.0-alpha02"
        const val ktx = "1.5.0-alpha03"
        const val hilt = "1.0.0-alpha02"
        const val viewModel = "2.3.0-alpha07"
        const val liveData = "2.3.0-alpha07"
        const val fragment = "1.3.0-alpha08"
        const val navigation = "2.3.0"
        const val material = "1.3.0-alpha02"
        const val constraintLayout = "2.0.1"
        const val vectorDrawable = "1.2.0-alpha02"
        const val dataStore = "1.0.0-alpha01"
        const val timber = "4.7.1"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val ktxFragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    const val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val vectorDrawable = "androidx.vectordrawable:vectordrawable:${Versions.vectorDrawable}"
    const val dataStoreCore = "androidx.datastore:datastore-core:${Versions.dataStore}"
    const val wireRuntime = "com.squareup.wire:wire-runtime:$wireVersion"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}
