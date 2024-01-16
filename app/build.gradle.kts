plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id(libs.plugins.daggerHilt.get().toString())
    id(libs.plugins.ksp.get().toString())
}

android {
    namespace = libs.plugins.mainNamespace.get().toString()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.plugins.mainNamespace.get().toString()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk =libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerVersion.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":navigation"))
    implementation(project(":core"))
    implementation(project(":home"))// just home Compose Screen
    implementation(project(":list")) // just list Compose Screen
    implementation(project(":detail")) // just list Compose Screen
    implementation(project(":network"))

    //region D.I Dependencies
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.ksp.compiler)
    implementation(libs.hilt.core)
    //endregion

    //region Compose Dependencies
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.compose.ui.material)
    androidTestImplementation(platform(libs.compose.bom))
    //endregion

    //region Core Dependencies
    implementation(libs.appcompat)
    implementation(libs.android.core)
    //endregion

    implementation(libs.lifecycle.ktx)

}