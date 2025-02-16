package taiwan.no.one.ricemaster.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import taiwan.no.one.ricemaster.impl.sake.di.SakeModule
import taiwan.no.one.ricemaster.network.di.NetworkModule
import taiwan.no.one.ricemaster.registration.di.RegistrationModule

/**
 * The `AppModule` is the main Koin module responsible for orchestrating the dependency injection throughout the
 * application. It consolidates various feature-specific modules to ensure comprehensive coverage of dependencies across
 * the app.
 *
 * Additionally, the `@ComponentScan` annotation ensures components within the "taiwan.no.one.ricemaster" package are
 * automatically detected and made available for dependency resolution, promoting loose coupling and modular structure.
 *
 * ⚠️⚠️ Please add new module here ⚠️⚠️
 */
@Module(
    includes = [
        NetworkModule::class,
        UtilModule::class,
        SakeModule::class,
        RegistrationModule::class,
    ],
)
@ComponentScan("taiwan.no.one.ricemaster")
class AppModule
