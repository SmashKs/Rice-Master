package taiwan.no.one.ricemaster.registration.di

import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.presentation.handler.FacebookSignIn
import taiwan.no.one.ricemaster.registration.presentation.handler.GoogleSignIn
import taiwan.no.one.ricemaster.registration.presentation.handler.SignInHandler
import taiwan.no.one.ricemaster.registration.presentation.handler.TwitterSignIn

actual val registrationPlatformModule: Module = module {
    factory<SignInHandler>(qualifier = named("google")) { GoogleSignIn() }
    factory<SignInHandler>(qualifier = named("facebook")) { FacebookSignIn() }
    factory<SignInHandler>(qualifier = named("twitter")) { TwitterSignIn() }
}
