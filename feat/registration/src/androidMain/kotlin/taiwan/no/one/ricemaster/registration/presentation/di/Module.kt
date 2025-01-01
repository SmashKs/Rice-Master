package taiwan.no.one.ricemaster.registration.presentation.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.presentation.auth.AndroidFirebaseAuth
import taiwan.no.one.ricemaster.registration.presentation.auth.FirebaseAuth

val registrationModuleProvider = module {
    factoryOf(::AndroidFirebaseAuth) bind FirebaseAuth::class
}
