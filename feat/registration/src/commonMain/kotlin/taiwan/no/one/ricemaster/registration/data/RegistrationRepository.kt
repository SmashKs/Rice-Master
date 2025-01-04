package taiwan.no.one.ricemaster.registration.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import taiwan.no.one.ricemaster.registration.data.model.LoginMethodModel
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.registration.data.source.RegistrationStore

@Factory
internal class RegistrationRepository(
    @Named("local") private val localStore: RegistrationStore,
    @Named("remote") private val remoteStore: RegistrationStore,
) : RegistrationRepo {
    override fun observeLoginFlow(): Flow<LoginModel> = localStore.fetchLoginDataFlow()

    override fun updateEmail(email: String): Unit = localStore.updateEmail(email)

    override fun updatePassword(password: String): Unit = localStore.updatePassword(password)

    override suspend fun createUser(): Result<Unit> {
        val (email, password) = localStore.fetchLoginDataFlow().first()
        return remoteStore.createUser(email = email, password = password)
    }

    override suspend fun signIn(): Result<Unit> {
        val (email, password) = localStore.fetchLoginDataFlow().first()
        return remoteStore.signIn(email = email, password = password)
    }

    override suspend fun signIn(method: LoginMethodModel): Result<Unit> = when (method) {
        is LoginMethodModel.Google -> remoteStore.signInWithGoogle(method.token)
        is LoginMethodModel.Facebook -> remoteStore.signInWithFacebook(method.token)
    }
}
