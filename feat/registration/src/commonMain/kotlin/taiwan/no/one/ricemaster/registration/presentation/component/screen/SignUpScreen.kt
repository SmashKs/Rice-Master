package taiwan.no.one.ricemaster.registration.presentation.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.AutoMirrored.Filled
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import taiwan.no.one.ricemaster.registration.presentation.component.textFieldValueSaver
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.Init.email
import taiwan.no.one.ricemaster.registration.presentation.entity.SignInUiState.Init.password
import taiwan.no.one.ricemaster.registration.presentation.entity.SignUpUiState
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.signup.SignUpEvent
import taiwan.no.one.ricemaster.ui.Sizing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SignUpScreen(
    state: SignUpUiState,
    modifier: Modifier = Modifier,
    eventHandler: (SignUpEvent) -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        TopAppBar(
            modifier = Modifier,
            title = {
                Text(text = "Sign Up")
            },
            navigationIcon = {
                IconButton(onClick = { eventHandler.invoke(SignUpEvent.GoBack) }) {
                    Icon(
                        imageVector = Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
            },
        )

        //region Input Fields
        var emailFieldVal by rememberSaveable(stateSaver = textFieldValueSaver, key = email) {
            mutableStateOf(TextFieldValue(text = email))
        }
        var passwordFieldVal by rememberSaveable(stateSaver = textFieldValueSaver, key = password) {
            mutableStateOf(TextFieldValue(text = password))
        }
        var confirmPassFieldVal by rememberSaveable(stateSaver = textFieldValueSaver, key = password) {
            mutableStateOf(TextFieldValue(text = password))
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = emailFieldVal,
                label = { Text("Email") },
                placeholder = { Text("Enter your email address") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
                trailingIcon = {
                    if (emailFieldVal.text.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                emailFieldVal = TextFieldValue()
                                eventHandler.invoke(SignUpEvent.UpdateEmail(""))
                            },
                        ) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear text")
                        }
                    }
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = {
                    emailFieldVal = it
                    eventHandler.invoke(SignUpEvent.UpdateEmail(it.text))
                },
            )

            Spacer(modifier = Modifier.height(Sizing.spacing8))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = passwordFieldVal,
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
                trailingIcon = {
                    if (passwordFieldVal.text.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                passwordFieldVal = TextFieldValue()
                                eventHandler.invoke(SignUpEvent.UpdatePassword(""))
                            },
                        ) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear text")
                        }
                    }
                },
                visualTransformation = PasswordVisualTransformation(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {
                    passwordFieldVal = it
                    eventHandler.invoke(SignUpEvent.UpdatePassword(it.text))
                },
            )

            Spacer(modifier = Modifier.height(Sizing.spacing8))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmPassFieldVal,
                label = { Text("Confirm Password") },
                placeholder = { Text("Enter your password again") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Confirm Password") },
                trailingIcon = {
                    if (confirmPassFieldVal.text.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                confirmPassFieldVal = TextFieldValue()
                                eventHandler.invoke(SignUpEvent.UpdateConfirmPassword(""))
                            },
                        ) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear text")
                        }
                    }
                },
                visualTransformation = PasswordVisualTransformation(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = {
                    confirmPassFieldVal = it
                    eventHandler.invoke(SignUpEvent.UpdateConfirmPassword(it.text))
                },
            )
        }
        //endregion

        Column(modifier = Modifier) {
            Button(
                onClick = { eventHandler.invoke(SignUpEvent.GotoSignIn) },
                content = { Text(text = "Sign In") },
            )

            Spacer(modifier = Modifier.size(size = Sizing.spacing8))

            Button(
                onClick = { eventHandler.invoke(SignUpEvent.SignUp) },
                content = { Text(text = "Sign Up") },
            )
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen(
            state = SignUpUiState.Input(
                email = "cassie.ward@example.com",
                password = "numquam",
                confirmPassword = "sententiae",
            ),
        )
    }
}
