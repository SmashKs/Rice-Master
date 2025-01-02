package taiwan.no.one.ricemaster.di

import android.content.Context
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import taiwan.no.one.ricemaster.R

@Single
internal actual class PlatformModule(
    private val context: Context,
) {
    @Named("web_client_id")
    actual fun getWebClientId(): String = context.getString(R.string.default_web_client_id)
}
