package taiwan.no.one.ricemaster.registration.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.mp.KoinPlatform
import taiwan.no.one.ricemaster.registration.data.RegistrationRepository
import taiwan.no.one.ricemaster.registration.domain.handler.CredentialHandler

interface GoogleLoginUseCase {
    suspend operator fun invoke(): Result<Unit>
}

@Factory
internal class GoogleLoginUseCaseImpl(
    private val repository: RegistrationRepository,
    @Named("io") private val ioDispatcher: CoroutineDispatcher,
) : GoogleLoginUseCase {
    private val credentialHandler: CredentialHandler by KoinPlatform.getKoin().inject()

    override suspend operator fun invoke(): Result<Unit> = withContext(ioDispatcher) {
        try {
            val token = credentialHandler.loginInWithGoogle()
            repository.signIn(token)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
