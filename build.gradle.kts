plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.androidKotlinMultiplatformLibrary) apply false
    alias(libs.plugins.kotlinCocoapods) apply false
}

allprojects {
    configurations
        .matching {
            it.name in listOf("androidReleaseCompileClasspath", "androidReleaseRuntimeClasspath")
        }.all {
            resolutionStrategy.activateDependencyLocking()
        }
}

subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            freeCompilerArgs.addAll(
                "-Xexpect-actual-classes",
                "-Xwhen-guards",
                "-Xnon-local-break-continue",
                "-Xmulti-dollar-interpolation",
                "-Xcontext-receivers",
            )
            if (System.getProperty("idea.active") == "true") {
                freeCompilerArgs.add("-Xdebug")
            }
        }
    }
}

// pre-requirement: brew install graphviz
// ./gradlew projectDependencyGraph
apply(file("gradle/projectDependencyGraph.gradle"))
