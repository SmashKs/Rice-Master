package taiwan.no.one.ricemaster.registration.data.source

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.SignInModel

interface UserFormStore {
    fun fetchSignInDataFlow(): Flow<SignInModel>

    fun updateEmail(value: String)

    fun updatePassword(value: String)
}
