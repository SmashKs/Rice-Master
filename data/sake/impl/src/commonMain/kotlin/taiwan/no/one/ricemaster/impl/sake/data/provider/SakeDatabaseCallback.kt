package taiwan.no.one.ricemaster.impl.sake.data.provider

import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase

@Factory
internal class SakeDatabaseCallback(
    private val database: SakeDatabase,
    @Named("io") private val dispatcher: CoroutineDispatcher,
) : RoomDatabase.Callback()
