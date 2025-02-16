package taiwan.no.one.ricemaster.impl.sake.di

import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase
import taiwan.no.one.ricemaster.impl.sake.data.getDatabaseBuilder

actual val sakePlatformModule: Module = module {
    single<RoomDatabase.Builder<SakeDatabase>> { getDatabaseBuilder() }
}
