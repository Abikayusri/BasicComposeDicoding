package com.sinau.mybasiccomposedicoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinau.mybasiccomposedicoding.ui.component.ContactCard
import com.sinau.mybasiccomposedicoding.ui.component.MyFloatingActionButton
import com.sinau.mybasiccomposedicoding.ui.component.MyTopAppBar
import com.sinau.mybasiccomposedicoding.ui.component.Spacing
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
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            MyTopAppBar()

            // Custom top bar
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .height(80.dp)
//                    .fillMaxWidth()
//                    .background(color = MaterialTheme.colorScheme.primary)
//            ) {
//                Image(
//                    painter = painterResource(R.drawable.dicoding_logo),
//                    contentDescription = null,
//                    modifier = Modifier.height(40.dp)
//                )
//            }
        },
        floatingActionButton = { MyFloatingActionButton() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(12.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column {
                ContactCard()
                Spacing()
                Text("Hello World")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    MyBasicComposeDicodingTheme {
        MyApp()
    }
}