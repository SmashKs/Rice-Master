package taiwan.no.one.ricemaster

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import taiwan.no.one.ricemaster.di.provideAppModule
import taiwan.no.one.ricemaster.registration.presentation.di.googleAuthModule

class RiceMaster : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RiceMaster)

            modules(provideAppModule)

            modules(googleAuthModule)
        }
    }
}
