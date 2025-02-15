package taiwan.no.one.ricemaster.registration.presentation.component.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import taiwan.no.one.ricemaster.registration.presentation.component.textFieldValueSaver
import taiwan.no.one.ricemaster.registration.presentation.viewmodel.forgot.ForgotPasswordEvent
import taiwan.no.one.ricemaster.ui.Sizing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    eventHandler: (ForgotPasswordEvent) -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        TopAppBar(
            modifier = Modifier,
            title = {
                Text(text = "Forgot Password")
            },
        )

        var emailFieldVal by rememberSaveable(stateSaver = textFieldValueSaver, key = "email") {
            mutableStateOf(TextFieldValue(text = ""))
        }

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
//                            eventHandler.invoke(SignUpEvent.UpdateEmail(""))
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
//                eventHandler.invoke(SignUpEvent.UpdateEmail(it.text))
            },
        )

        Spacer(modifier = Modifier.height(Sizing.spacing8))

        Button(
            onClick = { eventHandler.invoke(ForgotPasswordEvent.Request(emailFieldVal.text)) },
            content = { Text(text = "Continue") },
        )
    }
}
