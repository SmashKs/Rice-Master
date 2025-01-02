package taiwan.no.one.ricemaster.di

import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Single
internal actual class PlatformModule {
    @Named("web_client_id")
    actual fun getWebClientId(): String = "test"
}
