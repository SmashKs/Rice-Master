package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.SignInModel

interface UserFormRepo {
    fun observeSignInFlow(): Flow<SignInModel>

    fun updateEmail(email: String)

    fun updatePassword(password: String)
}
