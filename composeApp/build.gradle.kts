import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.googleplayServices)
    alias(libs.plugins.firebaseCrashlytics)
    alias(libs.plugins.googleKsp)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":core:network"))
            implementation(project(":core:ui"))
            implementation(project(":core:util"))
            implementation(project(":core:navigation"))

            implementation(project(":data:sake:impl"))
            implementation(project(":data:favorite:impl"))

            implementation(project(":feat:search"))
            implementation(project(":feat:profile"))
            implementation(project(":feat:identity"))
            implementation(project(":feat:favorite"))
            implementation(project(":feat:photo"))
            implementation(project(":feat:registration"))

            with(compose) {
                implementation(runtime)
                implementation(foundation)
                implementation(material3)
                implementation(ui)
                implementation(components.resources)
                implementation(components.uiToolingPreview)
            }
            // android
            with(libs.androidx) {
                implementation(lifecycle.viewmodel)
                implementation(lifecycle.runtime.compose)
                implementation(navigation.compose)
            }
            // kotlin
            with(libs.kotlinx) {
                implementation(datetime)
                implementation(collections.immutable)
            }
            // internet
            implementation(libs.ktor.client.core)
            // dependency injection
            with(libs.koin) {
                implementation(project.dependencies.platform(bom))
                implementation(core)
                implementation(mm.compose)
                implementation(mm.viewmodel.navigation)
                implementation(annotations)
            }
        }

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.ktor.client.android)

            implementation(libs.koin.android)

            with(libs.firebase) {
                implementation(project.dependencies.platform(bom))
                implementation(crashlyticsKtx)
            }

            implementation(libs.facebook.login)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        // https://insert-koin.io/docs/setup/annotations#kotlin-multiplatform-ksp-setup
        named("commonMain").configure {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }

        all {
            languageSettings.enableLanguageFeature("ExplicitBackingFields")
        }
    }
}

android {
    namespace = "taiwan.no.one.ricemaster"
    compileSdk = libs.versions.android.compileSdk
        .get()
        .toInt()

    defaultConfig {
        applicationId = "taiwan.no.one.ricemaster"
        minSdk = libs.versions.android.minSdk
            .get()
            .toInt()
        targetSdk = libs.versions.android.targetSdk
            .get()
            .toInt()
        versionCode = 1
        versionName = "1.0"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
//        debugImplementation(libs.androidx.compose.ui.tooling)
    }
}

// KSP Tasks
dependencies {
    add("kspCommonMainMetadata", libs.koin.ksp.compiler)
    add("kspAndroid", libs.koin.ksp.compiler)
    add("kspIosX64", libs.koin.ksp.compiler)
    add("kspIosArm64", libs.koin.ksp.compiler)
    add("kspIosSimulatorArm64", libs.koin.ksp.compiler)
}

ksp {
    arg("KOIN_USE_COMPOSE_VIEWMODEL", "true")
    arg("KOIN_CONFIG_CHECK", "true")
}

project.tasks.withType(KotlinCompilationTask::class.java).configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

dependencyLocking {
    lockMode.set(LockMode.LENIENT) // or STRICT if needed
}
