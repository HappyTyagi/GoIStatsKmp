package `in`.gov.mospi.goistats.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import goistats.shared.generated.resources.Res
import goistats.shared.generated.resources.bgsplash
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = remember { SplashViewModel() }
) {
    LaunchedEffect(Unit) {
        delay(3000L)
        val shouldNavigate = splashViewModel.shouldNavigateToHome()
        if (shouldNavigate) {
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        // 🔹 Background Image
        Image(
            painter = painterResource(Res.drawable.bgsplash),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Fill the screen
            modifier = Modifier
                .fillMaxSize()
                .zIndex(0f)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Star, contentDescription = "Logo", tint = Color.Blue, modifier = Modifier.size(80.dp))
            Text("My App", fontSize = 24.sp)
            Text("My App", fontSize = 24.sp)
            Text("My App", fontSize = 24.sp)
        }
    }
}
