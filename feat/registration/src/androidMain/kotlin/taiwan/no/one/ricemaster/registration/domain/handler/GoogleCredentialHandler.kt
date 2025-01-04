package taiwan.no.one.ricemaster.registration.domain.handler

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import org.koin.core.annotation.Factory
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform

@Factory
internal class GoogleCredentialHandler(private val context: Context) : CredentialHandler {
    private val webClientId: String by KoinPlatform.getKoin().inject(named("web_client_id"))

    @Composable
    override fun loginInWithFacebook(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val latestOnSuccess by rememberUpdatedState(onSuccess)
        val latestOnError by rememberUpdatedState(onError)
        val latestOnComplete by rememberUpdatedState(onComplete)

        val activity = LocalContext.current as ComponentActivity
        val loginManager = LoginManager.getInstance()
        val callbackManager = CallbackManager.Factory.create()

        loginManager.logIn(
            activityResultRegistryOwner = activity,
            callbackManager = callbackManager,
            permissions = listOf("email", "public_profile"),
        )

        DisposableEffect(Unit) {
            loginManager.registerCallback(
                callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onCancel() {
                        // do nothing
                        latestOnComplete()
                    }

                    override fun onError(error: FacebookException) {
                        latestOnError(error)
                        latestOnComplete()
                    }

                    override fun onSuccess(result: LoginResult) {
                        latestOnSuccess(result.accessToken.token)
                        latestOnComplete()
                    }
                },
            )

            onDispose { loginManager.unregisterCallback(callbackManager) }
        }
    }

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
