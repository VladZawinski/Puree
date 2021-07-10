// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.5.10")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.escatatic.buildsrc.ProjectPlugin.gradlePlugin)
        classpath(com.escatatic.buildsrc.ProjectPlugin.kotlinGradlePlugin)
        classpath(com.escatatic.buildsrc.ProjectPlugin.hiltGradlePlugin)
        classpath(com.escatatic.buildsrc.ProjectPlugin.butterKnife)
        classpath(com.escatatic.buildsrc.ProjectPlugin.safeArgPlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://jitpack.io") }
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}