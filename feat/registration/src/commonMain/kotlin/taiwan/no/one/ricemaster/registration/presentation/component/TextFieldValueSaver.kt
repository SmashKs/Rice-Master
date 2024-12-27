package taiwan.no.one.ricemaster.registration.presentation.component

import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

internal val textFieldValueSaver = listSaver<TextFieldValue, Any>(
    save = { listOf(it.text, it.selection.start, it.selection.end) },
    restore = { TextFieldValue(it[0] as String, TextRange(it[1] as Int, it[2] as Int)) },
)
