package taiwan.no.one.ricemaster.registration.data.repository.impl

import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Named
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.registration.data.model.SignUpInfoModel
import taiwan.no.one.ricemaster.registration.data.repository.SignUpFormRepo
import taiwan.no.one.ricemaster.registration.data.source.SignInUpFormStore

@Factory
internal class SignUpFormRepository(
    @Named("local") @Provided private val localFormStore: SignInUpFormStore,
) : SignUpFormRepo {
    override fun observeSignUpFlow(): Flow<SignUpInfoModel> = localFormStore.signUpDataFlow

    override fun updateEmail(email: String): Unit = localFormStore.updateSignInEmail(email)

    override fun updatePassword(password: String): Unit = localFormStore.updateSignInPassword(password)

    override fun updateConfirmPassword(password: String): Unit = localFormStore.updateSignUpConfirmPassword(password)
}
