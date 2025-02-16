package taiwan.no.one.ricemaster.impl.sake.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Singleton
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase

@Module
@ComponentScan
class SakeModule {
    @Singleton
    internal fun getSakeDatabase(
        @Provided builder: RoomDatabase.Builder<SakeDatabase>,
        @Provided presetCallback: RoomDatabase.Callback,
    ): SakeDatabase = builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .addCallback(presetCallback)
        .build()
}
