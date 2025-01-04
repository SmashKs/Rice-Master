package taiwan.no.one.ricemaster.registration.presentation.component.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import taiwan.no.one.ricemaster.registration.presentation.component.textFieldValueSaver

@Composable
internal fun LoginFieldsSection(
    email: String,
    password: String,
    modifier: Modifier = Modifier,
    onEmailValChange: (String) -> Unit = {},
    onPassValChange: (String) -> Unit = {},
) {
    var emailFieldVal by rememberSaveable(stateSaver = textFieldValueSaver, key = email) {
        mutableStateOf(TextFieldValue(text = email))
    }
    var passwordFieldVal by rememberSaveable(stateSaver = textFieldValueSaver, key = password) {
        mutableStateOf(TextFieldValue(text = password))
    }

    Column(
        modifier = modifier.fillMaxWidth(),
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
                            onEmailValChange("")
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
                onEmailValChange(it.text)
            },
        )

        Spacer(modifier = Modifier)

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
                            onPassValChange("")
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
                onPassValChange(it.text)
            },
        )
    }
}
