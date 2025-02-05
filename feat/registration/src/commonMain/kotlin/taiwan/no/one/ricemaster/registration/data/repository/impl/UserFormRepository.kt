package taiwan.no.one.ricemaster.registration.data.repository.impl

import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.registration.data.repository.UserFormRepo
import taiwan.no.one.ricemaster.registration.data.source.UserFormStore

@Factory
internal class UserFormRepository(
    @Named("local") @Provided private val localUserFormStore: UserFormStore,
) : UserFormRepo {
    override fun observeLoginFlow(): Flow<LoginModel> = localUserFormStore.fetchLoginDataFlow()

    override fun updateEmail(email: String): Unit = localUserFormStore.updateEmail(email)

    override fun updatePassword(password: String): Unit = localUserFormStore.updatePassword(password)
}
