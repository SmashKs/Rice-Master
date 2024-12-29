package taiwan.no.one.ricemaster.registration.presentation.auth

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth as AndroidFirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

internal class AndroidFirebaseAuth : FirebaseAuth {
    private val auth = AndroidFirebaseAuth.getInstance()

    @Composable
    override fun signInWithTwitter(
        onSuccess: (User) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val provider = OAuthProvider
            .newBuilder("twitter.com")
            .addCustomParameter("lang", "en")
            // Force re-consent.
            .addCustomParameter("prompt", "consent")
            .build()
        val activity = LocalContext.current as Activity

        auth
            .startActivityForSignInWithProvider(activity, provider)
            .addOnSuccessListener { authResult ->
                val user = authResult.user
                if (user != null) {
                    onSuccess(User(user.uid, user.displayName.orEmpty(), user.email.orEmpty()))
                } else {
                    onError(Exception("Sign-in successful, but user is null"))
                }
            }
            .addOnFailureListener(onError)
    }

    override fun createUser(
        email: String,
        password: String,
        onSuccess: (User) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val user = it.user
                if (user == null) {
                    onError(IllegalStateException("The user didn't finish the registration, please complete it"))
                } else {
                    onSuccess(user.convertToUser())
                }
            }
            .addOnFailureListener(onError)
    }

    override fun signIn(
        email: String,
        password: String,
        onSuccess: (User) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val user = it.user
                if (user == null) {
                    onError(IllegalStateException("The user didn't finish the registration, please complete it"))
                } else {
                    onSuccess(user.convertToUser())
                }
            }
            .addOnFailureListener(onError)
    }

    private fun FirebaseUser.convertToUser() = User(
        idToken = uid,
        displayName = displayName.orEmpty(),
        profilePicUrl = photoUrl?.path,

    )
}
