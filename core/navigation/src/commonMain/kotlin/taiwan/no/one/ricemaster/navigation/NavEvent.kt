package taiwan.no.one.ricemaster.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavController

@Stable
interface NavEvent {
    fun NavController.navigate()
}
