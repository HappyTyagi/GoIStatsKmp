package `in`.gov.mospi.goistats

import androidx.compose.ui.window.ComposeUIViewController
import `in`.gov.mospi.goistats.app.App
import `in`.gov.mospi.goistats.app.AppNavigation
import `in`.gov.mospi.goistats.ui.SplashScreen

fun MainViewController() = ComposeUIViewController(

) { AppNavigation() }