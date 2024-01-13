package com.sinau.mybasiccomposedicoding

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

private val sampleName = listOf(
    "Andre",
    "Desta",
    "Parto",
    "Wendy",
    "Komeng",
    "Raffi Ahmad",
    "Andhika Pratama",
    "Vincent Ryan Rompies"
)

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
                    GreetingList(sampleName)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyBasicComposeDicodingTheme {
        Greeting("Android")
    }
}

@Composable
fun ColumnExample(name: String) {
//    Column(modifier = Modifier.weight(1f)) {
//        Text(
//            text = "Hello Bro $name",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//        Text("Welcome to Dicoding")
//    }
}

@Preview(showBackground = true)
@Composable
fun ColumnExamplePreview() {
    MyBasicComposeDicodingTheme {
        ColumnExample("Bro Abika")
    }
}

@Composable
fun RowExample(name: String) {

    var isExpanded by remember { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )
//    Row(
//        modifier = Modifier.padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = painterResource(R.drawable.jetpack_compose),
//            contentDescription = "Logo Jetpack Compose",
//            modifier = Modifier.size(animatedSizeDp)
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//        Column(modifier = Modifier.weight(1f)) {
//            Text(
//                text = "Hello $name!",
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//            )
//            Text(
//                text = "Welcome to Dicoding!",
//                style = MaterialTheme.typography.bodyLarge.copy(
//                    fontStyle = FontStyle.Italic
//                )
//            )
//        }
//        IconButton(onClick = { isExpanded = !isExpanded }) {
//            Icon(
//                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
//                contentDescription = if (isExpanded) "Show less" else "Show more"
//            )
//        }
//    }


    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.jetpack_compose),
                contentDescription = "Logo Jetpack Compose",
                modifier = Modifier.size(animatedSizeDp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hello $name!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Welcome to Dicoding!",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontStyle = FontStyle.Italic
                    )
                )
            }
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                    contentDescription = if (isExpanded) "Show less" else "Show more"
                )
            }
        }
    }


//    Row(
//        modifier = Modifier.padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Image(
//            painter = painterResource(R.drawable.jetpack_compose),
//            contentDescription = "Logo Jetpack Compose",
//            modifier = Modifier.size(80.dp)
//        )
//        Spacer(modifier = Modifier.width(8.dp))
////        ColumnExample(name = "Adamame")
//        ColumnExample(name)
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                imageVector = Icons.Outlined.ExpandMore,
//                contentDescription = "Show More"
//            )
//        }
//    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RowExamplePreview() {
    MyBasicComposeDicodingTheme {
        RowExample("Bro Abika")
    }
}

// region list

@Composable
fun HelloJetpackComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        GreetingList(sampleName)
    }
}

@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
//        Column {
//            for (name in names) {
//                RowExample(name)
//            }
//        }

        LazyColumn {
            items(names) { name ->
                RowExample(name)
            }
        }
    } else {
        Text("No People to greet :(")
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HelloJetpackComposeAppPreview() {
    MyBasicComposeDicodingTheme {
        HelloJetpackComposeApp()
    }
}

// endregion