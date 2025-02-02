package taiwan.no.one.ricemaster.registration.di

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
@ComponentScan
class RegistrationModule {
    @Factory
    fun getFirebaseAuth(): FirebaseAuth = Firebase.auth
}
