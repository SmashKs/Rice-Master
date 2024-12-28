package taiwan.no.one.ricemaster.registration.presentation.component.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import taiwan.no.one.ricemaster.registration.presentation.auth.FirebaseAuth
import taiwan.no.one.ricemaster.ui.Sizing

@Composable
internal fun ButtonSection(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
) {
//    val googleAuthProvider = koinInject<GoogleAuthProvider>()
//    val googleAuthUiProvider = googleAuthProvider.getUiProvider()
    val coroutineScope = rememberCoroutineScope()
    val firebaseAuth = koinInject<FirebaseAuth>()

    Column {
        Button(
//            onClick = onLoginClick,
            onClick = {
            },
            content = {
                Text(text = "Login")

                firebaseAuth.signInWithTwitter(
                    onSuccess = {
                        println("#################################################")
                        println(it)
                        println("#################################################")
                    },
                    onError = {
                        println("=================================================")
                        println(it)
                        println("=================================================")
                    },
                )
            },
        )

        Spacer(modifier = Modifier.size(size = Sizing.spacing8))

        Button(
            onClick = onSignUpClick,
            content = {
                Text(text = "Sign Up")
            },
        )
    }
}
