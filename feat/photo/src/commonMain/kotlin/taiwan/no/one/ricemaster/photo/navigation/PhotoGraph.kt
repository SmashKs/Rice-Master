package taiwan.no.one.ricemaster.photo.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import taiwan.no.one.ricemaster.navigation.Graph.PhotoGraph
import taiwan.no.one.ricemaster.photo.component.PhotoRoute

@Serializable
private data object PhotoRoute

fun NavGraphBuilder.PhotoGraph() {
    navigation<PhotoGraph>(startDestination = PhotoRoute) {
        composable<PhotoRoute> { PhotoRoute() }
    }
}
