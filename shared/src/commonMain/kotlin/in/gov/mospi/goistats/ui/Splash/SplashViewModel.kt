package `in`.gov.mospi.goistats.ui.Splash

import kotlinx.coroutines.delay

// shared/src/commonMain/kotlin/SplashViewModel.kt
class SplashViewModel {
    suspend fun shouldNavigateToHome(): Boolean {
        delay(2000) // simulate splash delay
        // Here you could check if user is logged in or onboarding complete
        return true
    }
}