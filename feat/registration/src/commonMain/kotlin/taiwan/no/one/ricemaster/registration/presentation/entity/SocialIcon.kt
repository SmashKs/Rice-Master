package taiwan.no.one.ricemaster.registration.presentation.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Face
import androidx.compose.ui.graphics.vector.ImageVector

enum class SocialIcon(
//    val drawableRes: DrawableResource,
    val drawableRes: ImageVector,
    val contentDesc: String? = null,
) {
    GOOGLE(
        drawableRes = Icons.Default.Face,
        contentDesc = "Google",
    ),
    TWITTER(
        drawableRes = Icons.Default.AccountCircle,
        contentDesc = "Twitter",
    ),
    FACEBOOK(
        drawableRes = Icons.Default.Create,
        contentDesc = "Facebook",
    ),
}
