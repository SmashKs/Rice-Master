package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.first
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.source.RegistrationStore
import taiwan.no.one.ricemaster.registration.data.source.UserFormStore
import taiwan.no.one.ricemaster.user.model.UserModel

@Factory
internal class RegistrationRepository(
    @Named("local") @Provided private val localUserFormStore: UserFormStore,
    @Named("remote") @Provided private val remoteRegistrationStore: RegistrationStore,
) : RegistrationRepo {
    override suspend fun createUser(): Result<UserModel> {
        val (email, password) = localUserFormStore.fetchLoginDataFlow().first()
        return remoteRegistrationStore.createUser(email = email, password = password)
    }

    override suspend fun signIn(): Result<UserModel> {
        val (email, password) = localUserFormStore.fetchLoginDataFlow().first()
        return remoteRegistrationStore.signIn(email = email, password = password)
    }
}
