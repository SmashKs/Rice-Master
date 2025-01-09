package taiwan.no.one.ricemaster.registration.di

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
@ComponentScan("taiwan.no.one.ricemaster.registration")
class RegistrationModule {
    @Factory
    fun getFirebaseAuth() = Firebase.auth
}
