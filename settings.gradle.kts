enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.60.5"
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "RiceMaster"

include(":composeApp")

include(":core:ui")
include(":core:network")
include(":core:navigation")
include(":core:util")
include(":core:persistence")

include(":data:user")
include(":data:sake:impl")
include(":data:sake:api")
include(":data:favorite:api")
include(":data:favorite:impl")

include(":feat:search")
include(":feat:identity")
include(":feat:profile")
include(":feat:favorite")
include(":feat:photo")
include(":feat:registration")
