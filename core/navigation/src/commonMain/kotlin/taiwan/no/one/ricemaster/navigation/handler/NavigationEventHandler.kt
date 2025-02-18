package taiwan.no.one.ricemaster.navigation.handler

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow
import taiwan.no.one.ricemaster.navigation.NavEvent

@Composable
fun <E : NavEvent> Flow<E>.handleNavigationEvents(
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
    handler: suspend (E) -> Unit,
) {
    LaunchedEffect(this) {
        flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .collect { event -> handler.invoke(event) }
    }
}

@Composable
fun <E : NavEvent> Flow<E>.handleNavigationEvents(
    navController: NavController,
    lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
) {
    LaunchedEffect(this) {
        flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .collect { event -> with(event) { navController.navigate() } }
    }
}
