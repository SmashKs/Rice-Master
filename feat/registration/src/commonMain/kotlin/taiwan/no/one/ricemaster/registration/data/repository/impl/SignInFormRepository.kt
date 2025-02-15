package taiwan.no.one.ricemaster.registration.data.repository.impl

import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.SignInInfoModel
import taiwan.no.one.ricemaster.registration.data.repository.SignInFormRepo
import taiwan.no.one.ricemaster.registration.data.source.SignInUpFormStore

@Factory
internal class SignInFormRepository(
    @Named("local") @Provided private val localFormStore: SignInUpFormStore,
) : SignInFormRepo {
    override fun observeSignInFlow(): Flow<SignInInfoModel> = localFormStore.signInDataFlow

    override fun updateEmail(email: String): Unit = localFormStore.updateSignInEmail(email)

    override fun updatePassword(password: String): Unit = localFormStore.updateSignInPassword(password)
}
