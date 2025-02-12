package taiwan.no.one.ricemaster.detail.di

import org.koin.core.module.Module
import org.koin.dsl.module
import taiwan.no.one.ricemaster.detail.data.SakeDatabase
import taiwan.no.one.ricemaster.detail.data.getDatabaseBuilder
import taiwan.no.one.ricemaster.detail.data.getSakeDatabase

actual val detailPlatformModule: Module = module {
    single<SakeDatabase> {
        val builder = getDatabaseBuilder()
        getSakeDatabase(builder)
    }
}
