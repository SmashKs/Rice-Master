package taiwan.no.one.ricemaster.registration.data.auth

import androidx.compose.runtime.Composable
// import androidx.compose.ui.interop.LocalUIViewController
// import cocoapods.FirebaseAuth.FIRAuth
// import cocoapods.FirebaseAuth.FIRAuthUIDelegateProtocol
// import cocoapods.FirebaseAuth.FIROAuthProvider
import kotlinx.cinterop.ExperimentalForeignApi
import taiwan.no.one.ricemaster.user.model.UserModel

@OptIn(ExperimentalForeignApi::class)
internal class IosFirebaseAuth : FirebaseAuth {
//    private val auth = FIRAuth.auth()

    @Composable
    override fun signInWithInstagram(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
    }

    @Composable
    override fun signInWithTwitter(
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onComplete: () -> Unit,
    ) {
//        val provider = FIROAuthProvider.providerWithProviderID("twitter.com").apply {
//            setCustomParameters(mapOf("lang" to "en", "prompt" to "consent"))
//        }
//        val uiDelegate = LocalUIViewController.current as FIRAuthUIDelegateProtocol
//        provider.getCredentialWithUIDelegate(uiDelegate) { credential, error ->
//            println("=================================================")
//            println(credential)
//            println(error)
//            println("=================================================")
//        }
    }

    override fun signInWithFacebook(
        authToken: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }

    override fun signInWithGoogle(
        authToken: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }

    override fun createUser(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }

    override fun signIn(
        email: String,
        password: String,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
    ) {
    }
}
