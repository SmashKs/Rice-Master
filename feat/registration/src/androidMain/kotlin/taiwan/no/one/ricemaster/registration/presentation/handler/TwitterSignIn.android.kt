package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.OAuthCredential
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.OAuthCredential as GitliveOAuthCredential
import dev.gitlive.firebase.auth.OAuthProvider
import dev.gitlive.firebase.auth.android
import dev.gitlive.firebase.auth.auth

internal class TwitterSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: (GitliveOAuthCredential) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val activity = LocalContext.current as ComponentActivity
        val provider = OAuthProvider("twitter.com").android

        Firebase.auth.android.startActivityForSignInWithProvider(activity, provider)
            .addOnSuccessListener {
                (it.credential as? OAuthCredential)
                    ?.let(::GitliveOAuthCredential)
                    ?.let(onSuccess)
                    ?: onError(Exception("Can't convert to GitliveOAuthCredential"))
            }
            .addOnFailureListener(onError)
            .addOnCompleteListener { onComplete() }
    }
}
