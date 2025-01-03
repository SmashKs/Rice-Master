package taiwan.no.one.ricemaster.di

import org.koin.core.module.Module
import taiwan.no.one.ricemaster.registration.di.registrationPlatformModule

fun platformModulesProvider() = listOf(
    platformModule,
    registrationPlatformModule,
)

expect val platformModule: Module
