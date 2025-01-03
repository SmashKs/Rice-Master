package taiwan.no.one.ricemaster.registration.presentation.component.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import org.jetbrains.compose.resources.painterResource
import taiwan.no.one.ricemaster.registration.presentation.entity.SocialIcon

@Composable
internal fun Login3PartyIconsSection(
    icons: ImmutableList<SocialIcon>,
    modifier: Modifier = Modifier,
    onClick: (SocialIcon) -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(
            items = icons,
            key = { index, item -> "$index : ${item.name}" },
            itemContent = { _, icon ->
                IconButton(
                    onClick = { onClick(icon) },
                    content = {
                        Icon(
                            painter = painterResource(icon.drawableRes),
                            contentDescription = icon.contentDesc,
                            tint = Color.Unspecified,
                        )
                    },
                )
            },
        )
    }
}
