package taiwan.no.one.ricemaster.di

import android.content.Context
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import taiwan.no.one.ricemaster.R
import taiwan.no.one.ricemaster.registration.presentation.di.googleAuthModule

actual val platformModule: Module = module {
    factory<String>(named("web_client_id")) {
        get<Context>().getString(R.string.default_web_client_id)
    }

    includes(googleAuthModule)
}
