package taiwan.no.one.ricemaster.di

import org.koin.core.module.Module
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.presentation.di.registrationModuleProvider

actual val platformModule: Module = module {
    includes(registrationModuleProvider)
}
