plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id(libs.plugins.daggerHilt.get().toString())
    id(libs.plugins.ksp.get().toString())
}

android {
    namespace = libs.plugins.detailNameSpace.get().toString()
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
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
}

dependencies {
    implementation(project(":core"))
    implementation(project(":network"))

    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
    ksp(libs.hilt.ksp.compiler)
    implementation(libs.retrofit.core)

    //region Presentation Dependencies
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.hilt.navigation)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.navigation)
    implementation(libs.pager)
    implementation(libs.compose.ui.material)
    implementation(libs.compose.activity)
    implementation(libs.coil)
    //endregion

    //region test
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.core)
    testImplementation(libs.android.test)
    testImplementation(libs.coroutines.test)
    //endregion
}