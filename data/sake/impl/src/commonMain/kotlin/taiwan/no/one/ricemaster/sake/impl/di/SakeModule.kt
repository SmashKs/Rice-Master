package taiwan.no.one.ricemaster.sake.impl.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Singleton
import taiwan.no.one.ricemaster.sake.impl.data.SakeDatabase

@Module
@ComponentScan
class SakeModule {
    @Singleton
    internal fun getSakeDatabase(
        @Provided @Named(type = SakeDatabase::class) builder: RoomDatabase.Builder<SakeDatabase>,
    ): SakeDatabase = builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
