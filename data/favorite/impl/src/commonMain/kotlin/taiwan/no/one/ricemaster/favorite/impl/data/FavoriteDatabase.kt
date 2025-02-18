package taiwan.no.one.ricemaster.favorite.impl.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import taiwan.no.one.ricemaster.favorite.impl.data.model.FavoriteModel
import taiwan.no.one.ricemaster.favorite.impl.data.repository.store.local.FavoriteDao
import taiwan.no.one.ricemaster.persistence.data.converter.DateConverter

@Database(
    entities = [
        FavoriteModel::class,
    ],
    version = 1, // Update the version if you add/change database schema in the future
    exportSchema = false, // Use true if you want to export the schema, generally used in production
)
@TypeConverters(DateConverter::class)
@ConstructedBy(FavoriteDatabaseConstructor::class)
internal abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}

// Room compiler generates the `actual` implementations
@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect object FavoriteDatabaseConstructor : RoomDatabaseConstructor<FavoriteDatabase> {
    override fun initialize(): FavoriteDatabase
}
