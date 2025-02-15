package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.SignInInfoModel

interface SignInFormRepo {
    fun observeSignInFlow(): Flow<SignInInfoModel>

    fun updateEmail(email: String)

    fun updatePassword(password: String)
}
