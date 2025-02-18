package taiwan.no.one.ricemaster.sake.impl.di

import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import taiwan.no.one.ricemaster.sake.impl.data.SakeDatabase
import taiwan.no.one.ricemaster.sake.impl.data.getDatabaseBuilder

actual val sakePlatformModule: Module = module {
    single<RoomDatabase.Builder<SakeDatabase>>(named<SakeDatabase>()) { getDatabaseBuilder(context = get()) }
}
