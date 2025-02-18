package taiwan.no.one.ricemaster.favorite.impl.di

import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import taiwan.no.one.ricemaster.favorite.impl.data.FavoriteDatabase
import taiwan.no.one.ricemaster.favorite.impl.data.getDatabaseBuilder

actual val favoritePlatformModule: Module = module {
    single<RoomDatabase.Builder<FavoriteDatabase>>(named<FavoriteDatabase>()) { getDatabaseBuilder(context = get()) }
}
