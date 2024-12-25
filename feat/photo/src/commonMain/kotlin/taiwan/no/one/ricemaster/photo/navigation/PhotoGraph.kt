package taiwan.no.one.ricemaster.photo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
data object PhotoGraph

@Serializable
private data object PhotoHome

fun NavController.navigateToPhoto(navOptions: NavOptions) = navigate(PhotoGraph, navOptions)

@Composable
fun PhotoGraphNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = PhotoHome,
    ) {
        composable<PhotoHome> {
        }
    }
}
