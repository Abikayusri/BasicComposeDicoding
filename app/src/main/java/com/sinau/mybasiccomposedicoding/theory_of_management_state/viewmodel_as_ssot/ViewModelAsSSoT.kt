package com.sinau.mybasiccomposedicoding.theory_of_management_state.viewmodel_as_ssot

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

data class ExampleUiState(
    val dataToDisplayOnScreen: List<Example> = emptyList(),
    val errorMessages: String = "",
    val loading: Boolean = false,
)

data class Example(
    val id: Int,
    val title: String,
    val description: String,
)

class MyRepository() {

}

data class Data(
    val data: List<Example> = emptyList(),
    val error: String = "",
    val loading: Boolean = false,
)

class ExampleViewModel(
    private val repository: MyRepository,
    private val savedState: SavedStateHandle,
) : ViewModel() {

    var uiState by mutableStateOf(ExampleUiState())
        private set

    val data: Flow<List<Data>> = repository.data

    // Business logic
    fun somethingRelatedToBusinessLogic() { /* ... */
    }
}

@Composable
fun ExampleScreen(viewModel: ExampleViewModel = viewModel) {

    val uiState = viewModel.uiState
    val data = viewModel.data.collectAsState
    /* ... */

    ExampleReusableComponent(
        someData = uiState.dataToDisplayOnScreen,
        onDoSomething = { viewModel.somethingRelatedToBusinessLogic() }
    )
}

@Composable
fun ExampleReusableComponent(someData: Any, onDoSomething: () -> Unit) {
    /* ... */
    Button(onClick = onDoSomething) {
        Text("Do something")
    }
}