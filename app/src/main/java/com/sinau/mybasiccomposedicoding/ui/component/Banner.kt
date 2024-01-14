package com.sinau.mybasiccomposedicoding.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinau.mybasiccomposedicoding.R
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.heightIn(160.dp)
        )
        Search()
    }
}

@Preview(showBackground = true)
@Composable
fun BannerPreview() {
    MyBasicComposeDicodingTheme {
        Banner()
    }
}