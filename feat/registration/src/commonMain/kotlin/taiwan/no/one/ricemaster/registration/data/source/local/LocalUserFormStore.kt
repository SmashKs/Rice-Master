package taiwan.no.one.ricemaster.registration.data.source.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import taiwan.no.one.ricemaster.map.ConcurrentMap
import taiwan.no.one.ricemaster.registration.data.model.LoginModel
import taiwan.no.one.ricemaster.registration.data.source.UserFormStore

@Single
@Named("local")
internal class LocalUserFormStore : UserFormStore {
    private val flowMap: ConcurrentMap<String, MutableStateFlow<LoginModel>> = ConcurrentMap()

    override fun fetchLoginDataFlow(): Flow<LoginModel> = flowMap.getOrPut(KEY) {
        MutableStateFlow(LoginModel())
    }

    override fun updateEmail(value: String) {
        flowMap[KEY]?.update {
            it.copy(email = value)
        }
    }

    override fun updatePassword(value: String) {
        flowMap[KEY]?.update {
            it.copy(password = value)
        }
    }

    companion object {
        private const val KEY = "fdkaj32+#!#frefi2r)FafdFDa" // random fixed key
    }
}
