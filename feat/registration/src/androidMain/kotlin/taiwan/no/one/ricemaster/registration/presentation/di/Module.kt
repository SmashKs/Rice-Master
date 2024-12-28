package taiwan.no.one.ricemaster.registration.presentation.di

import androidx.credentials.CredentialManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import taiwan.no.one.ricemaster.registration.presentation.auth.GoogleAuthProvider
import taiwan.no.one.ricemaster.registration.presentation.auth.GoogleAuthProviderImpl

val googleAuthModule = module {
    factory { CredentialManager.create(androidContext()) } bind CredentialManager::class
    factoryOf(::GoogleAuthProviderImpl) bind GoogleAuthProvider::class
}
