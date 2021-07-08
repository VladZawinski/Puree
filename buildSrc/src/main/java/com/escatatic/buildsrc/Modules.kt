package com.escatatic.buildsrc

object Modules {
    const val CORE = ":core"
    const val NAVIGATION = ":navigation"
    const val DATA = ":data"
    const val DOMAIN = ":domain"

    const val FEATURE_HOME = ":features:home"
    const val FEATURE_EXPLORE = ":features:explore"
    const val FEATURE_PLAN = ":features:plan"
    const val FEATURE_PROFILE = ":features:profile"
}

fun modulesForFeatureModules() = listOf<String>(
    Modules.CORE,
    Modules.DOMAIN,
    Modules.NAVIGATION
)