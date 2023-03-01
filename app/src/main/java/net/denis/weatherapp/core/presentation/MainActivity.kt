package net.denis.weatherapp.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import net.denis.weatherapp.core.presentation.navigation.SetupNavGraph
import net.denis.weatherapp.core.presentation.navigation.test.NavGraph
import net.denis.weatherapp.core.presentation.navigation.test.NavigationManager
import net.denis.weatherapp.core.presentation.ui.theme.WeatherAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavGraph()
                    NavGraph()
                }
            }
        }
    }
}