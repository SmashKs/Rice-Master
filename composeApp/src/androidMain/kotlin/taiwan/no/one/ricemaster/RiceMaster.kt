package taiwan.no.one.ricemaster

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import taiwan.no.one.ricemaster.di.AppModule

class RiceMaster : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RiceMaster)

            modules(AppModule().module)
        }
    }
}
