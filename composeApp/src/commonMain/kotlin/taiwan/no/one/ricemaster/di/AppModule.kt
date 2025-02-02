package taiwan.no.one.ricemaster.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import taiwan.no.one.ricemaster.network.di.NetworkModule
import taiwan.no.one.ricemaster.registration.di.RegistrationModule

@Module(includes = [RegistrationModule::class, NetworkModule::class, UtilModule::class])
@ComponentScan("taiwan.no.one.ricemaster")
class AppModule
