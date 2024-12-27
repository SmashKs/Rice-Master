package taiwan.no.one.ricemaster.registration.presentation.entity

import org.jetbrains.compose.resources.DrawableResource
import ricemaster.feat.registration.generated.resources.Res
import ricemaster.feat.registration.generated.resources.ic_facebook
import ricemaster.feat.registration.generated.resources.ic_google
import ricemaster.feat.registration.generated.resources.ic_instagram
import ricemaster.feat.registration.generated.resources.ic_twitter

enum class SocialIcon(
    val drawableRes: DrawableResource,
    val contentDesc: String? = null,
) {
    GOOGLE(
        drawableRes = Res.drawable.ic_google,
        contentDesc = "Google",
    ),
    TWITTER(
        drawableRes = Res.drawable.ic_twitter,
        contentDesc = "Twitter",
    ),
    FACEBOOK(
        drawableRes = Res.drawable.ic_facebook,
        contentDesc = "Facebook",
    ),
    INSTAGRAM(
        drawableRes = Res.drawable.ic_instagram,
        contentDesc = "Instagram",
    ),
}
