package com.escatatic.buildsrc

import org.gradle.api.artifacts.dsl.DependencyHandler;
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.PluginDependenciesSpecScope
import org.gradle.plugin.use.PluginDependenciesSpec

object ProjectPlugin {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugins}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradle}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:2.36"
    const val butterKnife = "com.jakewharton:butterknife-gradle-plugin:10.1.0"
    const val safeArgPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val androidLibrary = "com.android.library"
    const val hiltPlugin = "dagger.hilt.android.plugin"
    const val butterKnife = "com.jakewharton.butterknife"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
}

object Apps {
    const val compileSdk = 30
    const val buildTools = "30.0.3"
    const val appId = "com.escatatic.puree"
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val jUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Versions {
    const val gradlePlugins = "4.2.2"
    const val kotlinGradle = "1.5.10"
    const val dagger = "2.37"
    const val navigation = "2.3.5"
    const val coreKtx = "1.5.0"
    const val fragmentKtx = "1.3.5"
    const val viewModelKtx = "2.4.0-alpha02"
    const val lifecycleKtx = "2.4.0-alpha02"
    const val appCompact = "1.3.0"
    const val material = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val jUnit = "4.+"
    const val jUnitExts = "1.1.2"
    const val espresso = "3.3.0"
    const val epoxy = "4.6.2"
    const val retrofit = "2.7.1"
    const val KAHelperRetrofit = "3.0.5"
    const val orbitMVI = "4.1.1"
    const val uniFlow = "1.0.9"
    const val glide = "4.12.0"
    const val insetter = "0.6.0"
}

object Dependencies {
    const val kotlinStdLibrary = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradle}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
    const val lifeCycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"

    const val appCompact = "androidx.appcompat:appcompat:${Versions.appCompact}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val navigationUIKTX = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationFragmentKTX = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.dagger}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val androidHiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"

    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
    const val epoxyCompiler = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val KAHelperRetrofit = "com.github.FunkyMuse.KAHelpers:retrofit:${Versions.KAHelperRetrofit}"

    const val orbitMVICore = "org.orbit-mvi:orbit-core:${Versions.orbitMVI}"
    const val orbitMVIViewModel = "org.orbit-mvi:orbit-viewmodel:${Versions.orbitMVI}"

    const val uniFlowCore = "org.uniflow-kt:uniflow-core:${Versions.uniFlow}"
    const val uniFlowAndroid = "org.uniflow-kt:uniflow-android:${Versions.uniFlow}"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val insetter = "dev.chrisbanes.insetter:insetter:${Versions.insetter}"

    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val jUnitExts = "androidx.test.ext:junit:${Versions.jUnitExts}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

fun DependencyHandler.common(){
    implementation(Dependencies.appCompact)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    testImpl(Dependencies.jUnit)
    androidTestImpl(Dependencies.jUnitExts)
    androidTestImpl(Dependencies.espresso)
    implementation(Dependencies.timber)
}

fun DependencyHandler.orbitMVI(){
    implementation(Dependencies.orbitMVICore)
    implementation(Dependencies.orbitMVIViewModel)
}

fun DependencyHandler.uniFlow(){
    implementation(Dependencies.uniFlowCore)
    implementation(Dependencies.uniFlowAndroid)
}

fun DependencyHandler.epoxy(){
    implementation(Dependencies.epoxy)
    implementation(Dependencies.epoxyDataBinding)
    kapt(Dependencies.epoxyCompiler)
}

fun DependencyHandler.dagger(){
    with(Dependencies){
        implementation(dagger)
        kapt(daggerCompiler)
        implementation(hilt)
        implementation(hiltViewModel)
        kapt(hiltCompiler)
        kapt(androidHiltCompiler)
    }
}

fun DependencyHandler.glide(){
    implementation(Dependencies.glide)
    kapt(Dependencies.glideCompiler)
}

fun DependencyHandler.retrofit(){
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitMoshi)
    implementation(Dependencies.KAHelperRetrofit)
}

fun DependencyHandler.ktxs(){
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.viewModelKtx)
    implementation(Dependencies.lifeCycleKtx)
}

fun DependencyHandler.navigation(){
    implementation(Dependencies.navigationFragmentKTX)
    implementation(Dependencies.navigationUIKTX)
}


