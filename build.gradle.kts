// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    // kotlin("kapt") version "1.9.10" kapt plugins added
    //id("org.jetbrains.kotlin.kapt") version "1.9.10" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.11" apply false

}

//safe args added
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.7.1"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}