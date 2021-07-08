import com.escatatic.buildsrc.*;

plugins {
    id(com.escatatic.buildsrc.Plugins.androidApplication)
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
        applicationId = Apps.appId
        versionCode = Apps.versionCode
        versionName = Apps.versionName

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
    implementation(project(Modules.CORE))
    implementation(project(Modules.FEATURE_EXPLORE))
    implementation(project(Modules.FEATURE_HOME))
    implementation(project(Modules.FEATURE_PLAN))
    implementation(project(Modules.FEATURE_PROFILE))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.DATA))
    implementation(project(Modules.NAVIGATION))

//    implementation(Dependencies.kotlinStdLibrary)
    common()
    ktxs()
    dagger()
    navigation()
}