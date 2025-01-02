package taiwan.no.one.ricemaster.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
internal class DispatchersModule {
    @Single
    @Named("main")
    fun mainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Single
    @Named("immediate")
    fun mainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

    @Single
    @Named("default")
    fun defaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Single
    @Named("io")
    fun ioDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
