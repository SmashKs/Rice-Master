package taiwan.no.one.ricemaster.registration.di

import android.content.Context
import org.koin.core.annotation.Factory
import taiwan.no.one.ricemaster.registration.data.auth.AndroidFirebaseAuth
import taiwan.no.one.ricemaster.registration.data.auth.FirebaseAuth
import taiwan.no.one.ricemaster.registration.presentation.auth.CredentialHandler
import taiwan.no.one.ricemaster.registration.presentation.auth.GoogleCredentialHandler

@Factory
internal actual class PlatformModule(
    private val context: Context,
) {
    actual fun getFirebaseAuth(): FirebaseAuth = AndroidFirebaseAuth()

    actual fun getCredentialHandler(): CredentialHandler = GoogleCredentialHandler(context)
}
