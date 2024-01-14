package com.sinau.mybasiccomposedicoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.sinau.mybasiccomposedicoding.model.dummyBestSellerMenu
import com.sinau.mybasiccomposedicoding.model.dummyMenu
import com.sinau.mybasiccomposedicoding.ui.component.SectionText
import com.sinau.mybasiccomposedicoding.ui.component.banner.Banner
import com.sinau.mybasiccomposedicoding.ui.component.category.CategoryRow
import com.sinau.mybasiccomposedicoding.ui.component.menu.MenuRow
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
        JetCoffeApp()
    }
}

@Composable
private fun JetCoffeApp(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Banner()
            SectionText(stringResource(R.string.section_category))
            CategoryRow()
            SectionText(stringResource(R.string.section_favorite_menu))
            MenuRow(dummyMenu)
            SectionText(stringResource(R.string.section_best_seller_menu))
            MenuRow(dummyBestSellerMenu)
        }
    }
}