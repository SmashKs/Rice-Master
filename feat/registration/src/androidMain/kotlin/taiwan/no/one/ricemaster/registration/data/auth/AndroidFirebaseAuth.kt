package taiwan.no.one.ricemaster.registration.data.auth

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.core.annotation.Factory
import taiwan.no.one.ricemaster.user.model.UserModel

@Factory
internal class AndroidFirebaseAuth : FirebaseAuth {
    private val auth = Firebase.auth

//    @Composable
//    override fun signInWithTwitter(
//        onSuccess: (UserModel) -> Unit,
//        onError: (Exception) -> Unit,
//    ) {
//        val provider = OAuthProvider
//            .newBuilder("twitter.com")
//            .addCustomParameter("lang", "en")
//            // Force re-consent.
//            .addCustomParameter("prompt", "consent")
//            .build()
//        val activity = LocalContext.current as Activity
//
//        auth.startActivityForSignInWithProvider(activity, provider)
//            .addOnSuccessListener { result -> successBlock(result, onError, onSuccess) }
//            .addOnFailureListener(onError)
//    }

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
