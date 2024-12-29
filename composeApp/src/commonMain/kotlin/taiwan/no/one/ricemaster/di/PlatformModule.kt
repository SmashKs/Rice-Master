package taiwan.no.one.ricemaster.di

import org.koin.core.module.Module
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.presentation.auth.GoogleAuthCredentials

expect val platformModule: Module

val utilModule = module {
    factory {
        GoogleAuthCredentials(
            serverId = "1036229269056-hi15fs1et3kbbt34een248jc9vhdhqng.apps.googleusercontent.com",
        )
    }
}
