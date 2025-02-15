package taiwan.no.one.ricemaster.registration.data.source

import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.registration.data.model.SignInInfoModel
import taiwan.no.one.ricemaster.registration.data.model.SignUpInfoModel

interface SignInUpFormStore {
    val signInDataFlow: Flow<SignInInfoModel>

    fun updateSignInEmail(value: String)

    fun updateSignInPassword(value: String)

    val signUpDataFlow: Flow<SignUpInfoModel>

    fun updateSignUPEmail(value: String)

    fun updateSignUPPassword(value: String)

    fun updateSignUpConfirmPassword(value: String)
}
