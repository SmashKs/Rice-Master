package taiwan.no.one.ricemaster.registration.domain.handler

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
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
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform

internal class AndroidCredentialHandler : CredentialHandler {
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
    @Composable
    override fun loginInWithGoogle(
        onSuccess: (String) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val latestOnSuccess by rememberUpdatedState(onSuccess)
        val latestOnError by rememberUpdatedState(onError)
        val latestOnComplete by rememberUpdatedState(onComplete)

        val activity = LocalContext.current as ComponentActivity
        val credentialManager = CredentialManager.create(activity)

        // NOTE(jieyi): 2025/01/06 this is the recommend way. However, it doesn't work well
//        val googleIdOption = GetGoogleIdOption.Builder()
//            .setFilterByAuthorizedAccounts(false)
//            .setServerClientId(webClientId)
//            .setAutoSelectEnabled(false)
//            .build()
//        val request: GetCredentialRequest = GetCredentialRequest.Builder()
//            .addCredentialOption(googleIdOption)
//            .build()
        val signInWithGoogleOption = GetSignInWithGoogleOption
            .Builder(webClientId)
            .build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(signInWithGoogleOption)
            .build()

        LaunchedEffect(Unit) {
            try {
                val credential = credentialManager.getCredential(context = activity, request = request).credential
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)

                latestOnSuccess(googleIdTokenCredential.idToken)
            } catch (e: Exception) {
                latestOnError(e)
            }
            latestOnComplete()
        }
    }
}
