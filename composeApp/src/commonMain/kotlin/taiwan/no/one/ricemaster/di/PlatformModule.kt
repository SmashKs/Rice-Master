package taiwan.no.one.ricemaster.di

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

expect val platformModule: Module

val utilModule = module {
    single(named("main")) { Dispatchers.Main }
    single(named("immediate")) { Dispatchers.Main.immediate }
    single(named("io")) { Dispatchers.IO }
    single(named("default")) { Dispatchers.Default }
}
