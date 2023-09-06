plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    //Safe args Added, to be sure android.useAndroidX=true in your gradle.properties file

    // kotlin("kapt") version "1.9.10" kapt plugins added
    //id("org.jetbrains.kotlin.kapt")
    id("com.google.devtools.ksp")
}



android {
    namespace = "com.mtoz147.ja1_kotlincountries"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mtoz147.ja1_kotlincountries"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 //java version is changed
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //navigation components added
    //https://developer.android.com/jetpack/androidx/releases/navigation
    val nav_version = "2.7.1"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //lifecycle components added
    //https://developer.android.com/jetpack/androidx/releases/lifecycle
    val lifecycle_version = "2.6.1"
    val arch_version = "2.2.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // optional - Test helpers for LiveData
    testImplementation("androidx.arch.core:core-testing:$arch_version")

    //Room components added
    //https://developer.android.com/jetpack/androidx/releases/room
    val room_version = "2.5.2"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    //https://kotlinlang.org/docs/kapt.html#annotation-processor-arguments
    //kapt("androidx.room:room-compiler:$room_version")
    //https://developer.android.com/build/migrate-to-ksp
    ksp("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")


    //material reference
    //https://developer.android.com/develop/ui/views/theming/look-and-feel
    //https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md
    implementation ("com.google.android.material:material:1.9.0")

}