package taiwan.no.one.ricemaster.registration.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.data.auth.AndroidFirebaseAuth
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.presentation.auth.CredentialHandler
import taiwan.no.one.ricemaster.registration.presentation.auth.GoogleCredentialHandler

val registrationModuleProvider = module {
    factoryOf(::AndroidFirebaseAuth) bind FirebaseAuth::class
    factoryOf(::GoogleCredentialHandler) bind CredentialHandler::class
}
