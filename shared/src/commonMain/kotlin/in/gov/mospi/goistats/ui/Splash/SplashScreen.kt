package `in`.gov.mospi.goistats.ui.Splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import goistats.shared.generated.resources.Res
import goistats.shared.generated.resources.bgsplash
import goistats.shared.generated.resources.mospi_logo
import `in`.gov.mospi.goistats.theme.SharedColors
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
        delay(3000000L)
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
        contentAlignment = Alignment.TopCenter
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

            Spacer(modifier = Modifier.height(80.dp))


            Image(
                painter = painterResource(Res.drawable.mospi_logo),
                contentDescription = null,
                contentScale = ContentScale.Fit, // You can also use Crop or FillBounds
                modifier = Modifier
                    .size(width = 245.dp, height = 135.dp) // 🔹 Set custom size here
                    .zIndex(0f)
            )

            Spacer(modifier = Modifier.height(65.dp))
            Text(
                text = "GoIStats Mobile App",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = SharedColors.Primary
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Empowering citizens with official \n data on-the-go",
                fontSize = 15.sp,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center,
                color = SharedColors.Primary
            )

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                "Data for Development", fontSize = 15.sp, fontWeight = FontWeight.SemiBold,
                color = SharedColors.Primary
            )
        }
    }
}
