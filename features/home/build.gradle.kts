import com.escatatic.buildsrc.*;

plugins {
    id(com.escatatic.buildsrc.Plugins.androidLibrary)
    id(com.escatatic.buildsrc.Plugins.kotlinAndroid)
    id(com.escatatic.buildsrc.Plugins.kotlinKapt)
    id(com.escatatic.buildsrc.Plugins.hiltPlugin)
    id(com.escatatic.buildsrc.Plugins.butterKnife)
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
    modulesForFeatureModules().forEach { implementation(project(it)) }
    common()
    ktxs()
    dagger()
    epoxy()
    uniFlow()


}