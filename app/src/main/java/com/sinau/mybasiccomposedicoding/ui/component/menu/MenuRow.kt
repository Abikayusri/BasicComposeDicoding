package com.sinau.mybasiccomposedicoding.ui.component.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinau.mybasiccomposedicoding.model.Menu
import com.sinau.mybasiccomposedicoding.model.dummyMenu
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuRowPreview() {
    MyBasicComposeDicodingTheme {
        MenuRow(dummyMenu)
    }
}