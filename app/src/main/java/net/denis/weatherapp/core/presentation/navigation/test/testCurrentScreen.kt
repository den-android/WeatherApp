package net.denis.weatherapp.core.presentation.navigation.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.weatherapp.features.main_forecast.model.ForecastItem

@Composable
fun testCurrentScreen(
    vm: TestCurrentVM,
) {
    testCurrentContent(
        onClickedContent = { vm.navigateToFetchCity() }
    )
}

@Composable
fun testCurrentContent(
    modifier: Modifier = Modifier,
    onClickedContent: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text("Current")
        Button(onClick = { onClickedContent() }) {
            Text("Button")
        }
    }
}