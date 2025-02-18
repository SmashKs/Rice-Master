package taiwan.no.one.ricemaster.favorite.impl.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Singleton
import taiwan.no.one.ricemaster.favorite.impl.data.FavoriteDatabase

@Module
@ComponentScan
class FavoriteModule {
    @Singleton
    internal fun getFavoriteDatabase(
        @Provided @Named(type = FavoriteDatabase::class) builder: RoomDatabase.Builder<FavoriteDatabase>,
    ): FavoriteDatabase = builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
