package com.sinau.mybasiccomposedicoding.ui.component

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinau.mybasiccomposedicoding.R
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

@Composable
fun ContactCard() {
    val context = LocalContext.current
    Row(
//        modifier = Modifier.padding(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(onClick = {
                Toast
                    .makeText(context, "Click", Toast.LENGTH_SHORT)
                    .show()
            }),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.avatar1),
                contentDescription = null,
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(CircleShape)

                modifier = Modifier
                    .padding(4.dp)
                    .border(2.dp, Color.Green, CircleShape)
                    .clip(CircleShape)
                    .size(60.dp)
            )

//            Icon(
//                imageVector = Icons.Default.CheckCircle,
//                contentDescription = null,
//                tint = Color.Green,
//                modifier = Modifier.align(Alignment.BottomEnd)
//            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Abika Chairul Yusri",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Online"
            )
        }

        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            modifier = Modifier.offset(x = 8.dp, y = 30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    MyBasicComposeDicodingTheme {
        ContactCard()
    }
}

@Composable
fun ButtonA() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200)),
        modifier = Modifier.size(100.dp)
    ) {
        Text("A")
    }
}

@Composable
fun ButtonB() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
        modifier = Modifier.size(80.dp)
    ) {
        Text("B")
    }
}

@Composable
fun ButtonC(text: String = "C") {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_700)),
        modifier = Modifier.size(60.dp)
    ) {
        Text(text)
    }
}

@Composable
fun RowButton() {
    Row(modifier = Modifier.padding(16.dp)) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun ColumnButton() {
    Column(modifier = Modifier.padding(16.dp)) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun BoxButton() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(16.dp)) {
        ButtonA()
        ButtonB()
        ButtonC("")
    }
}

@Composable
fun BasicLayout() {
    Row(modifier = Modifier.padding(16.dp)) {
        RowButton()
        ColumnButton()
        BoxButton()
    }
}

@Preview(showBackground = true)
@Composable
fun BoxButtonPreview() {
    BasicLayout()
}

@Composable
fun ColumnAlignment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text("Start")
            Spacing()
            ButtonA()
            Spacing()
            ButtonB()
            Spacing()
            ButtonC()
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("CenterHorizontally")
            Spacing()
            ButtonA()
            Spacing()
            ButtonB()
            Spacing()
            ButtonC()
        }
        Column(horizontalAlignment = Alignment.End) {
            Text("End")
            Spacing()
            ButtonA()
            Spacing()
            ButtonB()
            Spacing()
            ButtonC()
        }
    }
}

@Composable
fun Spacing() {
    Spacer(modifier = Modifier.padding(8.dp))
}

@Preview(showBackground = true)
@Composable
fun ColumnAlignmentPreview() {
    ColumnAlignment()
}

@Composable
fun RowAlignment() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Top                      ",
//                modifier = Modifier.align(Alignment.CenterVertically)
            )
            ButtonA()
            ButtonB()
            ButtonC()
        }
        Spacing()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CenterVertically")
            ButtonA()
            ButtonB()
            ButtonC()
        }
        Spacing()
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Bottom                ",
//                modifier = Modifier.align(Alignment.CenterVertically)
            )
            ButtonA()
            ButtonB()
            ButtonC()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowAlignmentPreview() {
    RowAlignment()
}

@Composable
fun BoxAlignment() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        ButtonWithText("TopStart", Modifier.align(Alignment.TopStart))
        ButtonWithText("TopCenter", Modifier.align(Alignment.TopCenter))
        ButtonWithText("TopEnd", Modifier.align(Alignment.TopEnd))
        ButtonWithText("CenterStart", Modifier.align(Alignment.CenterStart))
        ButtonWithText("Center", Modifier.align(Alignment.Center))
        ButtonWithText("CenterEnd", Modifier.align(Alignment.CenterEnd))
        ButtonWithText("BottomStart", Modifier.align(Alignment.BottomStart))
        ButtonWithText("BottomCenter", Modifier.align(Alignment.BottomCenter))
        ButtonWithText("BottomEnd", Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true, widthDp = 500, heightDp = 200)
@Composable
fun BoxAlignmentPreview() {
    BoxAlignment()
}

@Composable
fun ButtonWithText(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
        modifier = modifier.padding(4.dp)
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}

@Composable
fun RowButtonMaxWidth(arrangement: Arrangement.Horizontal = Arrangement.Start) {
    Row(
        horizontalArrangement = arrangement, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        ButtonC("")
        Spacing()
        ButtonC("")
        Spacing()
        ButtonC("")
    }
}

@Composable
fun Arrangement() {
    Column(modifier = Modifier.fillMaxWidth()) {
        RowButtonMaxWidth(Arrangement.Start)
        RowButtonMaxWidth(Arrangement.End)
        RowButtonMaxWidth(Arrangement.Center)
        RowButtonMaxWidth(Arrangement.SpaceEvenly)
        RowButtonMaxWidth(Arrangement.SpaceAround)
        RowButtonMaxWidth(Arrangement.SpaceBetween)
    }
}

@Preview(showBackground = true)
@Composable
fun ArrangementPreview() {
    Arrangement()
}

@Composable
fun Weight() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("1", Modifier.weight(1f))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("2", Modifier.weight(2f))
            ButtonWithText("1", Modifier.weight(1f))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("2", Modifier.weight(2f))
            ButtonWithText("3", Modifier.weight(3f))
        }

        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("2", Modifier.weight(2f))
            ButtonWithText("3 fill true", Modifier.weight(weight = 3f, fill = true))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f, true))
            ButtonWithText("2", Modifier.weight(2f, true))
            ButtonWithText("3 fill false", Modifier.weight(weight = 3f, fill = false))
        }
        Row {
            ButtonWithText("1", Modifier.weight(1f))
            ButtonWithText("0")
            ButtonWithText("0")
        }
    }
}

@Preview(showBackground = true, widthDp = 600)
@Composable
fun WeightPreview() {
    Weight()
}