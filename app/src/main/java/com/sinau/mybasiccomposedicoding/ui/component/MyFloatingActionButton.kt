package com.sinau.mybasiccomposedicoding.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(onClick = {}) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}