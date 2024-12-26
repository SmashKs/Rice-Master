package taiwan.no.one.ricemaster.di

import org.koin.dsl.module
import taiwan.no.one.ricemaster.network.di.networkModuleProvider

val provideAppModule = module {
    includes(networkModuleProvider)
}
