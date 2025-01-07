package taiwan.no.one.ricemaster.registration.data.auth

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import taiwan.no.one.ricemaster.user.model.UserModel

internal class AndroidFirebaseAuth : FirebaseAuth {
    private val auth = Firebase.auth

    @Composable
    override fun signInWithInstagram(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val provider = OAuthProvider
            .newBuilder("instagram.com")
            .addCustomParameter("lang", "en")
            // Force re-consent.
            .addCustomParameter("prompt", "consent")
            .build()
        val activity = LocalContext.current as ComponentActivity

        val task = if (auth.pendingAuthResult != null) {
            auth.pendingAuthResult
        } else {
            auth.startActivityForSignInWithProvider(activity, provider)
        }

        task?.addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
            ?.addOnFailureListener(onError)
            ?.addOnCompleteListener { onComplete() }
    }

    @Composable
    override fun signInWithTwitter(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
        val provider = OAuthProvider
            .newBuilder("twitter.com")
            .addCustomParameter("lang", "en")
            // Force re-consent.
            .addCustomParameter("prompt", "consent")
            .build()
        val activity = LocalContext.current as ComponentActivity

        val task = if (auth.pendingAuthResult != null) {
            auth.pendingAuthResult
        } else {
            auth.startActivityForSignInWithProvider(activity, provider)
        }

        task?.addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
            ?.addOnFailureListener(onError)
            ?.addOnCompleteListener { onComplete() }
    }

    override fun signInWithFacebook(
        authToken: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val credential = FacebookAuthProvider.getCredential(authToken)

        auth.signInWithCredential(credential)
            .addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
            .addOnFailureListener(onError)
    }

    override fun signInWithGoogle(
        authToken: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val credential = GoogleAuthProvider.getCredential(authToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
            .addOnFailureListener(onError)
    }

    override fun createUser(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
            .addOnFailureListener(onError)
    }

    override fun signIn(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
            .addOnFailureListener(onError)
    }

    private fun successBlock(
        result: AuthResult,
        onError: (Exception) -> Unit,
        onSuccess: (UserModel) -> Unit,
    ) {
        val user = result.user
        if (user == null) {
            onError(IllegalStateException("The user didn't finish the registration, please complete it"))
        } else {
            onSuccess(user.convertToUser())
        }
    }

    private fun FirebaseUser.convertToUser() = UserModel(
        idToken = uid,
        displayName = displayName.orEmpty(),
        profilePicUrl = photoUrl?.path,

    )
}
