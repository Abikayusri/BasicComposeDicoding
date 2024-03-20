package com.sinau.mybasiccomposedicoding

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

data class Contact(
    val id: Int,
    val name: String,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColorBox2() {
    val list = remember { mutableStateListOf<Contact>() }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item(span = { GridItemSpan(2) }) {
            Button(onClick = {
                list.add(Contact(Random.nextInt(1000), "new name"))
            }) {
                Text("Add")
            }ππππ
        }

        items(list, key = { it.id }) { item ->
            val color by remember {
                mutableStateOf(
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
                )
            }
            Button(
                onClick = { list.remove(item) },
                colors = ButtonDefaults.buttonColors(color),
                modifier = Modifier
                    .height(120.dp)
                    .animateItemPlacement(tween(durationMillis = 250))
            ) {
                Text(item.id.toString())
            }
        }
    }
}