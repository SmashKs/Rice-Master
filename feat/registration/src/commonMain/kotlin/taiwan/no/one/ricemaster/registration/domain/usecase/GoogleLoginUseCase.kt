package taiwan.no.one.ricemaster.registration.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import taiwan.no.one.ricemaster.registration.data.RegistrationRepository
import taiwan.no.one.ricemaster.registration.presentation.auth.CredentialHandler

interface GoogleLoginUseCase {
    suspend operator fun invoke(): Result<Unit>
}

@Factory
internal class GoogleLoginUseCaseImpl(
    private val repository: RegistrationRepository,
) : GoogleLoginUseCase, KoinComponent {
    private val credentialHandler: CredentialHandler by inject()
    private val ioDispatcher: CoroutineDispatcher by inject(named("io"))

    override suspend operator fun invoke(): Result<Unit> = withContext(ioDispatcher) {
        try {
            val token = credentialHandler.loginInWithGoogle()
            repository.signIn(token)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
