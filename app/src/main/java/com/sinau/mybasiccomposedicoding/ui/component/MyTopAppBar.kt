package com.sinau.mybasiccomposedicoding.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.sinau.mybasiccomposedicoding.ui.theme.MyBasicComposeDicodingTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    var showMenu by remember { mutableStateOf(false) }
    var showFavorite by remember { mutableStateOf(false) }

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        title = {
            Text(text = "My Scaffold")
        },
        actions = {
            IconButton(onClick = { showFavorite = !showFavorite }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
            }
            DropdownMenu(
                expanded = showFavorite,
                onDismissRequest = { showFavorite = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Texting me") },
                    onClick = {}
                )
            }

            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Call me") },
                    onClick = {}
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyTopAppBarPreview() {
    MyBasicComposeDicodingTheme {
        MyTopAppBar()
    }
}