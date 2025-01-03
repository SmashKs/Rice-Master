package taiwan.no.one.ricemaster.registration.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.data.auth.AndroidFirebaseAuth
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.domain.handler.CredentialHandler
import taiwan.no.one.ricemaster.registration.domain.handler.GoogleCredentialHandler

actual val registrationPlatformModule: Module = module {
    factoryOf(::GoogleCredentialHandler) bind CredentialHandler::class
    factoryOf(::AndroidFirebaseAuth) bind FirebaseAuth::class
}
