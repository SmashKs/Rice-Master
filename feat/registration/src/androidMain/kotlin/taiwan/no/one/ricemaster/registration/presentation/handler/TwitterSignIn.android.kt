package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.OAuthProvider
import dev.gitlive.firebase.auth.android
import dev.gitlive.firebase.auth.auth

internal class TwitterSignIn : SignInHandler {
    @Composable
    override fun SignIn(
        onSuccess: () -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val activity = LocalContext.current as ComponentActivity
        val provider = OAuthProvider("twitter.com").android

        Firebase.auth.android.startActivityForSignInWithProvider(activity, provider)
            .addOnSuccessListener {
                val credential = it.credential
                onSuccess()
            }
            .addOnFailureListener(onError)
            .addOnCompleteListener { onComplete() }
    }
}
