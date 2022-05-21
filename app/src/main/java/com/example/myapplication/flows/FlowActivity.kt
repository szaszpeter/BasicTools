package com.example.myapplication.flows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapplication.flows.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FlowActivity : ComponentActivity() {

    // Lazy Inject ViewModel
    val viewModel: FlowViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        EnterTextItem()
                        DisplayTextItem()
                    }
                }
            }
        }
        watchTextChange()
    }

    private fun watchTextChange() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Trigger the flow and start listening for values.
                // Note that this happens when lifecycle is STARTED and stops
                // collecting when the lifecycle is STOPPED
                viewModel.uiState.collect { uiState ->
                    // New value received
                    when (uiState) {
                        is LatestUIState.Success -> text.value = uiState.newText
                        is LatestUIState.Error -> text.value = uiState.exception.message.toString()
                    }
                }
            }
        }
    }

    @Composable
    fun EnterTextItem() {
        var textValue by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            // Update value of textValue with the latest value of the text field
            onValueChange = {
                textValue = it
                viewModel.onTextChanged(it.text)
            }
        )
    }

    val text = mutableStateOf("")

    @Composable
    private fun DisplayTextItem() {
        Row(modifier = Modifier.fillMaxWidth()) {
            // Text is a predefined composable that does exactly what you'd expect it to -
            // display text on the screen. It allows you to customize its appearance using
            // the style property.
            Text(
                text = text.value,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}


