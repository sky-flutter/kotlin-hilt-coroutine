import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    private const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val core = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"
    private const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"

    //Networking
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val gsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    private const val okHttpBom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
    private const val okHttp = "com.squareup.okhttp3:okhttp"
    private const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor"

    //Testing
    private const val jUnit = "junit:junit:${Versions.jUnit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Hilt
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdlib)
        add(core)
        add(appCompat)
        add(constraintLayout)
        add(material)
        add(annotation)
        add(liveData)
        add(viewModel)
        add(retrofit)
        add(gsonConverter)
        add(okHttpBom)
        add(okHttp)
        add(okHttpLogging)
        add(hilt)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(jUnit)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espresso)
    }

    val hiltKapt = arrayListOf<String>().apply {
        add(hiltCompiler)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}