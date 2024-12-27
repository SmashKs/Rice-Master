package taiwan.no.one.ricemaster.registration.data

import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.registration.data.source.RegistrationStore

@Single
internal class RegistrationRepository(
    private val localStore: RegistrationStore,
) : RegistrationRepo {
    override fun observeLoginFlow(): Flow<LoginModel> = localStore.fetchLoginDataFlow()

    override fun updateEmail(email: String) {
        localStore.updateEmail(email)
    }

    override fun updatePassword(password: String) {
        localStore.updatePassword(password)
    }
}
