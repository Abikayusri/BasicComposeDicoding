package com.sinau.mybasiccomposedicoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBasicComposeDicodingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Add code here
                    ButtonCounter(Modifier)
                }
            }
        }
    }
}

@Composable
fun ButtonCounter(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        var count by rememberSaveable { mutableIntStateOf(0) }

        /* Use this for stateless composable */
        StatelessCounter(
            count = count,
            onClick = { count++ },
            modifier = modifier
        )

        /* Use this for normal function */
//        Text("Button Click $count times:")
//        Spacer(modifier = modifier.height(20.dp))
//        Button(onClick = { count++ }) {
//            Text(text = "Click Me!")
//        }
    }
}

@Composable
fun StatelessCounter(
    count: Int,             // state
    onClick: () -> Unit,    // event
    modifier: Modifier = Modifier
) {
    Text("Button Click $count times:")
    Spacer(modifier = modifier.height(20.dp))
    Button(onClick = { onClick() }) {
        Text(text = "Click Me!")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonCounterPreview() {
    MyBasicComposeDicodingTheme {
        ButtonCounter()
    }
}
