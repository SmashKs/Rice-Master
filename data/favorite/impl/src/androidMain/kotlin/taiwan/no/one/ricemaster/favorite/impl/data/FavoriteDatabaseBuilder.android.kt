package taiwan.no.one.ricemaster.favorite.impl.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

internal fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<FavoriteDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("favorite_database.db")

    return Room.databaseBuilder<FavoriteDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}
