package taiwan.no.one.ricemaster.impl.sake.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

internal fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<SakeDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("sake_database.db")

    return Room.databaseBuilder<SakeDatabase>(
        context = appContext,
        name = dbFile.absolutePath,
    )
}
