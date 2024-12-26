plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.medicationmanagementmodule"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.medicationmanagementmodule"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.activity)
    androidTestImplementation(libs.espresso.core)

    // Room components
    implementation("androidx.room:room-runtime:${rootProject.extra["roomVersion"]}")
    annotationProcessor("androidx.room:room-compiler:${rootProject.extra["roomVersion"]}")
    androidTestImplementation("androidx.room:room-testing:${rootProject.extra["roomVersion"]}")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1") // Latest version for ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1") // Latest version for LiveData
    implementation("androidx.lifecycle:lifecycle-common-java8:${rootProject.extra["lifecycleVersion"]}")

    // UI components
    implementation(libs.material)
    implementation(libs.constraintlayout)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation("androidx.arch.core:core-testing:${rootProject.extra["coreTestingVersion"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${rootProject.extra["espressoVersion"]}") {
        exclude(group = "com.android.support",module="support-annotations")
    }
    androidTestImplementation(libs.ext.junit)

    implementation ("androidx.room:room-runtime:2.5.0")
    annotationProcessor ("androidx.room:room-compiler:2.5.0") // For Java

}