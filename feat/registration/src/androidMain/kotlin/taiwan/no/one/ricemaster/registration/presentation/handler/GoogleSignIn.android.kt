package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.GoogleAuthProvider
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.android
import dev.gitlive.firebase.auth.auth
import org.koin.core.qualifier.named
import org.koin.mp.KoinPlatform

internal class GoogleSignIn : SignInHandler {
    private val webClientId: String by KoinPlatform.getKoin().inject(named("web_client_id"))

    @Composable
    override fun SignIn(
        onSuccess: () -> Unit,
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

                val authCredential = GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)

                Firebase.auth.android.signInWithCredential(authCredential)
                    .addOnSuccessListener { latestOnSuccess() }
                    .addOnFailureListener(latestOnError)
                    .addOnCompleteListener { latestOnComplete() }
            } catch (e: Exception) {
                latestOnError(e)
            }
            latestOnComplete()
        }
    }
}
