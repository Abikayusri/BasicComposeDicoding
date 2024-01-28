package com.sinau.mybasiccomposedicoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBasicComposeDicodingTheme {
                // Add code here
                StatefulTemperatureApp()
            }
        }
    }
}

@Composable
fun StatefulTemperatureApp(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            StatefulTemperatureInput()
            ConverterApp()
            TwoWayConverterApp()
        }
    }
}

// region stateful temperature input function

@Composable
fun StatefulTemperatureInput(
    modifier: Modifier = Modifier
) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }

    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.stateful_converter),
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = input,
            label = { Text(text = stringResource(R.string.enter_celsius)) },
            // keyboardOptions digunakan untuk mengkonfigurasi tampilan keyboard
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newInput ->
                input = newInput
                output = convertToFahrenheit(newInput)
            }
        )

        Text(text = stringResource(R.string.temperature_fahrenheit, output))
    }
}

fun convertToFahrenheit(celsius: String): String =
    celsius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()

// endregion

// region converter app stateless function

@Composable
fun StatelessTemperatureInput(
    input: String,
    output: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.stateless_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = input,
            label = {
                Text(text = stringResource(R.string.enter_celsius))
            },
            keyboardOptions = KeyboardOptions(),
            onValueChange = onValueChange
        )
        Text(text = stringResource(R.string.temperature_fahrenheit, output))
    }
}

@Composable
fun ConverterApp(
    modifier: Modifier = Modifier
) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(modifier) {
        StatelessTemperatureInput(
            input = input,
            output = output,
            onValueChange = { newInput ->
                input = newInput
                output = convertToFahrenheit(newInput)
            }
        )
    }
}

// endregion

// region two way converter function

@Composable
fun TwoWayConverterApp(
    modifier: Modifier = Modifier
) {
    var celcius by remember {
        mutableStateOf("")
    }

    var fahrenheit by remember {
        mutableStateOf("")
    }

    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.two_way_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        GeneralTemperatureInput(
            scale = Scale.CELCIUS,
            input = celcius,
            onValueChange = { newInput ->
                celcius = newInput
                fahrenheit = convertToFahrenheit(newInput)
            }
        )

        GeneralTemperatureInput(
            scale = Scale.FAHRENHEIT,
            input = fahrenheit,
            onValueChange = { newInput ->
                fahrenheit = newInput
                celcius = convertToCelsius(newInput)
            }
        )
    }
}

@Composable
fun GeneralTemperatureInput(
    scale: Scale,
    input: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        OutlinedTextField(
            value = input,
            label = { Text(stringResource(R.string.enter_temperature, scale.scaleName)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange,
        )
    }
}

private fun convertToCelsius(fahrenheit: String) =
    fahrenheit.toDoubleOrNull()?.let {
        (it - 32) * 5 / 9
    }.toString()

// endregion

@Preview
@Composable
fun StatefulTemperatureAppPreview() {
    MyBasicComposeDicodingTheme {
        StatefulTemperatureApp()
    }
}