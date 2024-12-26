package taiwan.no.one.ricemaster

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin
import taiwan.no.one.ricemaster.network.di.networkModuleProvider

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(networkModuleProvider)
        }
    },
    content = { RiceMasterApp() },
)
