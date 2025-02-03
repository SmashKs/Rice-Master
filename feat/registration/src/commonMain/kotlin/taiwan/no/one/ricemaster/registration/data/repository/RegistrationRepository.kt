package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.LoginMethodModel
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.registration.data.source.RegistrationStore
import taiwan.no.one.ricemaster.user.model.UserModel

@Factory
internal class RegistrationRepository(
    @Named("local") @Provided private val localStore: RegistrationStore,
    @Named("remote") @Provided private val remoteStore: RegistrationStore,
) : RegistrationRepo {
    override fun observeLoginFlow(): Flow<LoginModel> = localStore.fetchLoginDataFlow()

    override fun updateEmail(email: String): Unit = localStore.updateEmail(email)

    override fun updatePassword(password: String): Unit = localStore.updatePassword(password)

    override suspend fun createUser(): Result<UserModel> {
        val (email, password) = localStore.fetchLoginDataFlow().first()
        return remoteStore.createUser(email = email, password = password)
    }

    override suspend fun signIn(): Result<UserModel> {
        val (email, password) = localStore.fetchLoginDataFlow().first()
        return remoteStore.signIn(email = email, password = password)
    }

    override suspend fun signIn(method: LoginMethodModel): Result<UserModel> = when (method) {
        is LoginMethodModel.Google -> remoteStore.signInWithGoogle(method.token)
        is LoginMethodModel.Facebook -> remoteStore.signInWithFacebook(method.token)
    }
}
