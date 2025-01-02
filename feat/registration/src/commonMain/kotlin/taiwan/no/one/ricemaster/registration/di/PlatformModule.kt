package taiwan.no.one.ricemaster.registration.di

import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.presentation.auth.CredentialHandler

internal expect class PlatformModule {
    fun getFirebaseAuth(): FirebaseAuth

    fun getCredentialHandler(): CredentialHandler
}
