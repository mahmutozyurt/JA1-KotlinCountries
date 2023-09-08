plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs")
    //Safe args Added, to be sure android.useAndroidX=true in your gradle.properties file

    // kotlin("kapt") version "1.9.10" kapt plugins added
    id("org.jetbrains.kotlin.kapt")
    //Note: Data Binding also requires kapt to be enabled in the module.
    // In modules where Data Binding is used, kapt can not be removed.
    //id("com.google.devtools.ksp")

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
    //https://developer.android.com/jetpack/androidx/releases/databinding
    buildFeatures {
        dataBinding = true
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

    //coroutines components added
    // threading ops.
    //https://github.com/Kotlin/kotlinx.coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    //navigation components added
    //https://developer.android.com/jetpack/androidx/releases/navigation
    val nav_version = "2.6.0"
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
    //Sql and Local database section
    //https://developer.android.com/jetpack/androidx/releases/room
    val room_version = "2.5.2"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // To use Kotlin annotation processing tool (kapt)
    //https://kotlinlang.org/docs/kapt.html#annotation-processor-arguments
    kapt("androidx.room:room-compiler:$room_version")
    //https://developer.android.com/build/migrate-to-ksp
    //ksp("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")


    //material reference
    //design ops.
    //https://developer.android.com/develop/ui/views/theming/look-and-feel
    //https://github.com/material-components/material-components-android/blob/master/docs/getting-started.md
    implementation ("com.google.android.material:material:1.9.0")

    //retrofit components added
    //  to exchange data with web as synchronize or asynchronous
    //https://github.com/square/retrofit/tree/master
    //https://github.com/square/retrofit/tree/master/retrofit-converters/gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava3
    //https://github.com/ReactiveX/RxJava for latest version
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")


    //rxJava components added
    //https://github.com/ReactiveX/RxJava
    implementation ("io.reactivex.rxjava3:rxjava:3.1.7")
    //https://github.com/ReactiveX/RxAndroid
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")


    //Glide components added
    //to download and to show picture from web (alternative picasso)
    //https://github.com/bumptech/glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")


    //Selecting Colors with the Palette API
    // After analyze background and give color advice to developer
   //https://developer.android.com/develop/ui/views/graphics/palette-colors
    implementation("com.android.support:palette-v7:28.0.0")
    implementation ("com.android.support:design:28.0.0")

    // user preferences are remembered
    //https://developer.android.com/jetpack/androidx/releases/preference
    implementation("androidx.preference:preference-ktx:1.2.1")

    //https://androidx.tech/artifacts/legacy/legacy-support-v4/
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")



}