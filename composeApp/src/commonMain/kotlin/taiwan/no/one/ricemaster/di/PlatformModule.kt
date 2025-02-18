package taiwan.no.one.ricemaster.di

import org.koin.core.module.Module
import taiwan.no.one.ricemaster.favorite.impl.di.favoritePlatformModule
import taiwan.no.one.ricemaster.registration.di.registrationPlatformModule
import taiwan.no.one.ricemaster.sake.impl.di.sakePlatformModule

fun platformModulesProvider() = listOf(
    platformModule,
    sakePlatformModule,
    favoritePlatformModule,
    registrationPlatformModule,
)

expect val platformModule: Module
