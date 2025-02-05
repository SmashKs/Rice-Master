package taiwan.no.one.ricemaster.registration.data.source

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.LoginModel

interface UserFormStore {
    fun fetchLoginDataFlow(): Flow<LoginModel>

    fun updateEmail(value: String)

    fun updatePassword(value: String)
}
