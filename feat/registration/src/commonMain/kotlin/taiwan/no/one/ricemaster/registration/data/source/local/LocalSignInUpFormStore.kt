package taiwan.no.one.ricemaster.registration.data.source.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import taiwan.no.one.ricemaster.map.ConcurrentMap
import taiwan.no.one.ricemaster.registration.data.model.SignInInfoModel
import taiwan.no.one.ricemaster.registration.data.model.SignUpInfoModel
import taiwan.no.one.ricemaster.registration.data.source.SignInUpFormStore

@Single
@Named("local")
internal class LocalSignInUpFormStore : SignInUpFormStore {
    private val signInFlowMap: ConcurrentMap<String, MutableStateFlow<SignInInfoModel>> = ConcurrentMap()
    private val signUpFlowMap: ConcurrentMap<String, MutableStateFlow<SignUpInfoModel>> = ConcurrentMap()

    override val signInDataFlow: Flow<SignInInfoModel>
        get() = signInFlowMap.getOrPut(SIGN_IN_KEY) { MutableStateFlow(SignInInfoModel()) }

    override fun updateSignInEmail(value: String) {
        signInFlowMap[SIGN_IN_KEY]?.update {
            it.copy(email = value)
        }
    }

    override fun updateSignInPassword(value: String) {
        signInFlowMap[SIGN_IN_KEY]?.update {
            it.copy(password = value)
        }
    }

    override val signUpDataFlow: Flow<SignUpInfoModel>
        get() = signUpFlowMap.getOrPut(SIGN_UP_KEY) { MutableStateFlow(SignUpInfoModel()) }

    override fun updateSignUPEmail(value: String) {
        signUpFlowMap[SIGN_UP_KEY]?.update {
            it.copy(email = value)
        }
    }

    override fun updateSignUPPassword(value: String) {
        signUpFlowMap[SIGN_UP_KEY]?.update {
            it.copy(password = value)
        }
    }

    override fun updateSignUpConfirmPassword(value: String) {
        signUpFlowMap[SIGN_UP_KEY]?.update {
            it.copy(confirmPassword = value)
        }
    }

    companion object {
        private const val SIGN_IN_KEY = "fdkaj32+#!#frefi2r)FafdFDa:SignIn" // random fixed key
        private const val SIGN_UP_KEY = "2T8bjkSd'21la~a03+#d1+)2(G:SignUp" // random fixed key
    }
}
