package taiwan.no.one.ricemaster.navigation

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable

@Stable
sealed interface Graph {
    @Serializable
    data object ProfileTopGraph : Graph

    @Serializable
    data object FavoriteTopGraph : Graph

    @Serializable
    data object IdentityTopGraph : Graph

    @Serializable
    data object SearchTopGraph

    @Serializable
    data object PhotoGraph : Graph

    @Serializable
    data object RegistrationGraph : Graph
}
