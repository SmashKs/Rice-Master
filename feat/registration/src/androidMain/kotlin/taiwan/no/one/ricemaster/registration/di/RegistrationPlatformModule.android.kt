package taiwan.no.one.ricemaster.registration.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.domain.handler.AndroidCredentialHandler
import taiwan.no.one.ricemaster.registration.domain.handler.CredentialHandler

actual val registrationPlatformModule: Module = module {
    factoryOf(::AndroidCredentialHandler) bind CredentialHandler::class
}
