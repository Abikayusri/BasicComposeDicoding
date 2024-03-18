package com.sinau.mybasiccomposedicoding.theory_of_management_state.state_holder_as_ssot

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// TODO: Untuk membuat state holder yang menangani input tersebut, buatlah class kosong yang berisi state, kemudian siapkan remember function, dan terakhir ganti state dan event dengan state holder yang sudah dibuat.
class FormInputState(initialInput: String) {
    var input by mutableStateOf(initialInput)
}

@Composable
private fun rememberFormInputState(input: String): FormInputState {
    return remember(input) {
        FormInputState(input)
    }
}

@Composable
fun MyForm() {
// Before use state
//    var input by remember { mutableStateOf("") }

// After use state
    val input = rememberFormInputState("")
    FormInput(
        state = input
    )
}

@Composable
// Before use state
//fun FormInput(input: String, onValueChange: (String) -> Unit) {
fun FormInput(
    state: FormInputState = rememberFormInputState(""),
) {

// Before use state
//    OutlinedTextField(
//        value = input,
//        onValueChange = onValueChange,
//        label = { Text("Nama") },
//        modifier = Modifier.padding(8.dp)
//    )

// After use state
    OutlinedTextField(
        value = state.input,
        onValueChange = { state.input = it },
        label = { Text("Nama") },
        modifier = Modifier.padding(8.dp)
    )
}

@Preview
@Composable
fun FormInputPreview() {
    MyForm()
}
