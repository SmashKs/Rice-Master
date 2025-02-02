import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.googleKsp)
    alias(libs.plugins.kotlinCocoapods)
}

kotlin {
    androidLibrary {
        namespace = "taiwan.no.one.ricemaster.registration"
        compileSdk = libs.versions.android.compileSdk
            .get()
            .toInt()
        minSdk = libs.versions.android.minSdk
            .get()
            .toInt()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "registration"
            isStatic = true
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"

        podfile = project.file("../../iosApp/Podfile")

        framework {
            baseName = "resgistration"
            isStatic = false
        }

        pod("GoogleSignIn")
        pod("FBSDKLoginKit") { version = "~> 13.0.0" }
    }

// Source set declarations.
// Declaring a target automatically creates a source set with the same name. By default, the
// Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
// common to share sources between related targets.
// See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:ui"))
            implementation(project(":core:navigation"))
            implementation(project(":core:util"))
            implementation(project(":core:network"))
            implementation(project(":data:user"))
            with(compose) {
                implementation(material3)
                implementation(components.resources)
                implementation(components.uiToolingPreview)
            }

            implementation(libs.kotlin.stdlib)
            with(libs.kotlinx) {
                implementation(coroutines.core)
                implementation(serialization.json)
                implementation(collections.immutable)
            }
            implementation(libs.androidx.navigation.compose)

            with(libs.koin) {
                implementation(project.dependencies.platform(bom))
                implementation(mm.compose)
                implementation(mm.viewmodel.navigation)
                implementation(annotations)
            }

            implementation(libs.firebase.multiplatform.auth)
        }

        androidMain.dependencies {
            implementation(project.dependencies.platform(libs.firebase.bom))
            implementation(libs.firebase.authKtx)

            implementation(libs.androidx.auth.credentials)
            implementation(libs.androidx.auth.playstore)
            implementation(libs.google.id)
            implementation(libs.play.services.auth)
            implementation(libs.facebook.login)
        }

        iosMain.dependencies {
            implementation(compose.runtime)
        }

        named("commonMain").configure {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }

        all {
            languageSettings.enableLanguageFeature("ExplicitBackingFields")
        }
    }
}

// KSP Tasks
dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
}

ksp {
    arg("KOIN_USE_COMPOSE_VIEWMODEL", "true")
    arg("KOIN_CONFIG_CHECK", "true")
}

tasks.withType<KotlinCompilationTask<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}
