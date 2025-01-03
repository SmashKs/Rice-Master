package taiwan.no.one.ricemaster.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        modules(
            AppModule().module,
        )

        modules(
            platformModulesProvider(),
        )

        config?.invoke(this)
    }
}
