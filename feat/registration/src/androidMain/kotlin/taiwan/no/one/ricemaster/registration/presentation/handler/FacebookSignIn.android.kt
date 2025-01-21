package taiwan.no.one.ricemaster.registration.presentation.handler

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.android
import dev.gitlive.firebase.auth.auth

internal class FacebookSignIn : SignInHandler {
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
        val loginManager = LoginManager.getInstance()
        val callbackManager = CallbackManager.Factory.create()

        DisposableEffect(Unit) {
            loginManager.registerCallback(
                callbackManager,
                object : FacebookCallback<LoginResult> {
                    // do nothing
                    override fun onCancel() = latestOnComplete()

                    override fun onError(error: FacebookException) {
                        latestOnError(error)
                        latestOnComplete()
                    }

                    override fun onSuccess(result: LoginResult) {
                        val credential = FacebookAuthProvider.getCredential(result.accessToken.token)

                        Firebase.auth.android.signInWithCredential(credential)
                            .addOnSuccessListener { latestOnSuccess() }
                            .addOnFailureListener(latestOnError)
                            .addOnCompleteListener { latestOnComplete() }
                    }
                },
            )

            loginManager.logIn(
                activityResultRegistryOwner = activity,
                callbackManager = callbackManager,
                permissions = listOf("email", "public_profile"),
            )

            onDispose { loginManager.unregisterCallback(callbackManager) }
        }
    }
}
