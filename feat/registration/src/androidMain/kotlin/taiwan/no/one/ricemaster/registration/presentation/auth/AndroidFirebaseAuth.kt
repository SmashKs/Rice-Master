package taiwan.no.one.ricemaster.registration.presentation.auth

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.CreatePasswordRequest
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.firebase.auth.FirebaseAuth as AndroidFirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import taiwan.no.one.ricemaster.user.model.UserModel

internal class AndroidFirebaseAuth(
    private val context: Context,
) : FirebaseAuth, KoinComponent {
    private val auth = AndroidFirebaseAuth.getInstance()
    private val webClientId: String by inject(named("web_client_id"))

    override suspend fun signInWithGoogle(
        onSuccess: (String, Bundle) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val credentialManager = CredentialManager.create(context)
        val googleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId("1036229269056-4q0ct27vldb9t7b1bhl5ecsipcq859hl.apps.googleusercontent.com")
            //            .setAutoSelectEnabled(false)
            .build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        try {
            //            val credential = credentialManager.getCredential(context = context, request = request).credential
            val credential = credentialManager.createCredential(
                context,
                CreatePasswordRequest("test@test.test", "test"),
            )
            onSuccess(credential.type, credential.data)
        } catch (e: Exception) {
            onError(e)
        }
    }

    @Composable
    override fun signInWithTwitter(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
        val provider = OAuthProvider
            .newBuilder("twitter.com")
            .addCustomParameter("lang", "en")
            // Force re-consent.
            .addCustomParameter("prompt", "consent")
            .build()
        val activity = LocalContext.current as Activity

        auth.startActivityForSignInWithProvider(activity, provider)
            .addOnSuccessListener { authResult ->
                val user = authResult.user
                if (user != null) {
                    onSuccess(UserModel(user.uid, user.displayName.orEmpty(), user.email.orEmpty()))
                } else {
                    onError(Exception("Sign-in successful, but user is null"))
                }
            }
            .addOnFailureListener(onError)
    }

    override fun createUser(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
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
        onSuccess: (UserModel) -> Unit,
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

    private fun FirebaseUser.convertToUser() = UserModel(
        idToken = uid,
        displayName = displayName.orEmpty(),
        profilePicUrl = photoUrl?.path,

    )
}
