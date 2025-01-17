package taiwan.no.one.ricemaster.registration.di

import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.domain.handler.CredentialHandler
import taiwan.no.one.ricemaster.registration.domain.handler.IosCredentialHandler

@OptIn(ExperimentalForeignApi::class)
actual val registrationPlatformModule: Module = module {
    factoryOf(::IosCredentialHandler) bind CredentialHandler::class
}
