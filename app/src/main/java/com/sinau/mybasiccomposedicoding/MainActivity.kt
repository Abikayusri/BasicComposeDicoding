package com.sinau.mybasiccomposedicoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBasicComposeDicodingTheme {
                // A surface container using the 'background' color from the theme
                JetCoffeApp()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactCardPreview() {
    MyBasicComposeDicodingTheme {
    }
}

@Composable
private fun JetCoffeApp() {

}