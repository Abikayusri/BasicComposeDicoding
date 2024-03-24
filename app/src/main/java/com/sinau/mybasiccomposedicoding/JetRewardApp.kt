package com.sinau.mybasiccomposedicoding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

@Composable
fun JetRewardApp(
    modifier: Modifier = Modifier,
) {

}

@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    MyBasicComposeDicodingTheme {
        JetRewardApp()
    }
}
