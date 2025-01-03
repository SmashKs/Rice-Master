package taiwan.no.one.ricemaster

import androidx.compose.ui.window.ComposeUIViewController
import taiwan.no.one.ricemaster.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    },
    content = { RiceMasterApp() },
)
