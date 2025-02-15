package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.SignUpInfoModel

interface SignUpFormRepo {
    fun observeSignUpFlow(): Flow<SignUpInfoModel>

    fun updateEmail(email: String)

    fun updatePassword(password: String)

    fun updateConfirmPassword(password: String)
}
