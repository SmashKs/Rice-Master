package taiwan.no.one.ricemaster.registration.presentation.auth

import android.content.Context
import android.credentials.GetCredentialException
import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

internal class GoogleAuthUiProviderImpl(
    private val activityContext: Context,
    private val credentialManager: CredentialManager,
    private val credentials: GoogleAuthCredentials,
) : GoogleAuthUiProvider {
    @RequiresApi(VERSION_CODES.UPSIDE_DOWN_CAKE)
    override suspend fun signIn(): User? = try {
        val credential = credentialManager
            .getCredential(
                context = activityContext,
                request = getCredentialRequest(),
            ).credential
        getGoogleUserFromCredential(credential)
    } catch (e: GetCredentialException) {
        println("=================================================")
        println("GoogleAuthUiProvider error: ${e.message}")
        println("=================================================")
        null
    } catch (e: NullPointerException) {
        null
    }

    private fun getGoogleUserFromCredential(credential: Credential): User? = when {
        credential is CustomCredential &&
            credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL -> {
            try {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                User(
                    idToken = googleIdTokenCredential.idToken,
                    displayName = googleIdTokenCredential.displayName.orEmpty(),
                    profilePicUrl = googleIdTokenCredential.profilePictureUri?.toString(),
                )
            } catch (e: GoogleIdTokenParsingException) {
                println("=================================================")
                println("GoogleAuthUiProvider Received an invalid google id token response: ${e.message}")
                println("=================================================")
                null
            }
        }
        else -> {
            null
        }
    }

    private fun getCredentialRequest(): GetCredentialRequest = GetCredentialRequest
        .Builder()
        .addCredentialOption(getGoogleIdOption(serverClientId = credentials.serverId))
        .build()

    private fun getGoogleIdOption(serverClientId: String): GetGoogleIdOption = GetGoogleIdOption
        .Builder()
        .setFilterByAuthorizedAccounts(false)
        .setAutoSelectEnabled(true)
        .setServerClientId(serverClientId)
        .build()
}
