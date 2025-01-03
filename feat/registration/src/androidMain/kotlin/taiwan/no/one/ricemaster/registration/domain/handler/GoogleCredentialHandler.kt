package taiwan.no.one.ricemaster.registration.domain.handler

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import org.koin.core.annotation.Factory
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform

@Factory
internal class GoogleCredentialHandler(private val context: Context) : CredentialHandler {
    private val webClientId: String by KoinPlatform.getKoin().inject(named("web_client_id"))

    @Throws(Exception::class)
    override suspend fun loginInWithGoogle(): String {
        val credentialManager = CredentialManager.create(context)
//        val googleIdOption = GetGoogleIdOption.Builder()
//            .setFilterByAuthorizedAccounts(false)
//            .setServerClientId("1036229269056-4q0ct27vldb9t7b1bhl5ecsipcq859hl.apps.googleusercontent.com")
//            .setAutoSelectEnabled(false)
//            .build()
        val signInWithGoogleOption = GetSignInWithGoogleOption
            .Builder(webClientId)
            .build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(signInWithGoogleOption)
            .build()

//            val credential = credentialManager.createCredential(
//                context,
//                CreatePasswordRequest("test@test.test", "test"),
//            )
        val credential = credentialManager.getCredential(context = context, request = request).credential
        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)

        return googleIdTokenCredential.idToken
    }
}
