import com.escatatic.buildsrc.*;

plugins {
    id(com.escatatic.buildsrc.Plugins.androidLibrary)
    id(com.escatatic.buildsrc.Plugins.kotlinAndroid)
    id(com.escatatic.buildsrc.Plugins.kotlinKapt)
    id(com.escatatic.buildsrc.Plugins.hiltPlugin)
}

android {
    compileSdk = Apps.compileSdk
    buildToolsVersion = Apps.buildTools

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = Apps.jUnitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    buildFeatures {
        dataBinding = true
    }

}

dependencies {
//    implementation(Dependencies.kotlinStdLibrary)
    common()
    ktxs()
    dagger()

}