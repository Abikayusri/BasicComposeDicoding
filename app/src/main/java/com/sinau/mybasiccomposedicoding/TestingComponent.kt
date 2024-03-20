package com.sinau.mybasiccomposedicoding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

@Composable
fun Contact(names: List<String>) {
    LazyColumn {
        item {
            Text(text = "Header 1", fontWeight = FontWeight.ExtraBold)
        }

        items(names) { name ->
            Text(text = name)
        }

        itemsIndexed(names) { index, item ->
            Text(text = "Item at index $index is $item")
        }
    }

    // Fixed -> Untuk jumlah kolom yang tetap
    // Adaptive -> Untuk menyesuaikan dengan lebar layar, hanya perlu definisikan ukuran minimal
    // Code di bawah digunakan untuk membuat custom GridCells sendiri untuk mengatur kolom sesuai keinginan
    LazyVerticalGrid(columns = object : GridCells {
        override fun Density.calculateCrossAxisCellSizes(
            availableSize: Int,
            spacing: Int,
        ): List<Int> {
            val firstColumn = (availableSize - spacing) * 2 / 3
            val secondColumn = availableSize - spacing - firstColumn
            return listOf(firstColumn, secondColumn)
        }
    }) {

    }
}

@Composable
private fun ColorBox1() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        // PaddingValues -> digunakan untuk menambahkan padding di sekeliling konten tanpa harus tercrop ketika di scroll
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        // verticalArrangement dan horizontalArrangement -> digunakan untuk menentukan posisi konten. Gunakan spacedBy untuk menambahkan jarak antar item
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        // span -> digunakan untuk menentukan lebar item pada kolom grid
        item(span = { GridItemSpan(2) }) {

        }

        // Fungsi lainnya
//        items(list) { item ->
//
//        }
    }
}

@Preview
@Composable
private fun ContactPreview() {
    val nameList = listOf("Abika", "Narendra", "Nadia")
    Contact(nameList)
}