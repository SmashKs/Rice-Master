package taiwan.no.one.ricemaster

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import taiwan.no.one.ricemaster.di.initKoin

class RiceMaster : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@RiceMaster)
        }
    }
}
