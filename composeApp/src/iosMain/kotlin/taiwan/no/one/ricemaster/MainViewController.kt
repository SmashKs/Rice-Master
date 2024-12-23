package taiwan.no.one.ricemaster

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
        }
    },
    content = { App() },
)
