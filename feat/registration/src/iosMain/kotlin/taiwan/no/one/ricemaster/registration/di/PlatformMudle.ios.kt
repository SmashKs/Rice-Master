package taiwan.no.one.ricemaster.registration.di

import org.koin.core.annotation.Factory
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.presentation.auth.CredentialHandler

@Factory
internal actual class PlatformModule {
    actual fun getFirebaseAuth(): FirebaseAuth = TODO()

    actual fun getCredentialHandler(): CredentialHandler = TODO()
}
