package `in`.gov.mospi.goistats.theme


import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun GoIStatsTheme(
    darkTheme: Boolean = false, // You can wire this to system settings
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = SharedColors.Primary,
            secondary = SharedColors.Secondary,
            background = Color.DarkGray,
            onPrimary = SharedColors.OnPrimary,
            onBackground = SharedColors.OnBackground,
        )
    } else {
        lightColorScheme(
            primary = SharedColors.Primary,
            secondary = SharedColors.Secondary,
            background = SharedColors.Background,
            onPrimary = SharedColors.OnPrimary,
            onBackground = SharedColors.OnBackground,
        )
    }

//    MaterialTheme(
//        colorScheme = colors,
//        typography = AppTypography,
//        shapes = AppShapes,
//        content = content
//    )
}
