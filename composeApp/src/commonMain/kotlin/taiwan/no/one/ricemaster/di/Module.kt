package taiwan.no.one.ricemaster.di

import org.koin.dsl.module
import org.koin.ksp.generated.module
import taiwan.no.one.ricemaster.registration.di.RegistrationModule

val provideAppModule = module {
//    includes(networkModule, platformModule)

    includes(RegistrationModule().module, UtilModule().module)
}
