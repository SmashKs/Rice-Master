package taiwan.no.one.ricemaster.registration.data.repository

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.LoginModel

interface UserFormRepo {
    fun observeLoginFlow(): Flow<LoginModel>

    fun updateEmail(email: String)

    fun updatePassword(password: String)
}
