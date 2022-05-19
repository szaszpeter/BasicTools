package com.example.myapplication.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.coroutines.ui.theme.MyApplicationTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class CoroutineActivity : ComponentActivity() {

    // Lazy Inject ViewModel
    val viewModel: CoroutineViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Couroutine", "Activity Launching")
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        SimpleCoroutineButton()
                        AsyncAwaitButton()
                        AsyncAwaitAllButton()
                        CoroutineScopeButton()
                        JobExampleButton()
                        CoroutineContextExampleButton()
                    }
                }
            }
        }
    }


    @Composable
    fun SimpleCoroutineButton() {
        Button(onClick = {
            viewModel.launchSampleCoroutine()
        }) {
            Text(text = "Launch Coroutine")
        }
    }

    @Composable
    fun AsyncAwaitButton() {
        Button(onClick = {
            viewModel.asyncAwaitSample()
        }) {
            Text(text = "Launch AsyncAwait")
        }
    }

    @Composable
    fun AsyncAwaitAllButton() {
        Button(onClick = {
            viewModel.asyncAwaitAllSample()
        }) {
            Text(text = "Launch AsyncAwait")
        }
    }

    @Composable
    fun CoroutineScopeButton() {
        Row{
            Button(onClick = {
                viewModel.customScopeMethod()
            }) {
                Text(text = "Coroutine Scope")
            }

            Button(onClick = {
                viewModel.cleanUp()
            }) {
                Text(text = "Cancel Scope")
            }
        }
    }

    @Composable
    fun JobExampleButton() {
        Row{
            Button(onClick = {
                viewModel.jobExampleMethod(false)
            }) {
                Text(text = "Job Example")
            }

            Button(onClick = {
                viewModel.jobExampleMethod(true)
            }) {
                Text(text = "Job Example With Cancel")
            }
        }
    }

    @Composable
    fun CoroutineContextExampleButton() {
        Button(onClick = {
            viewModel.coroutineContextExample()
        }) {
            Text(text = "Coroutine Context")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        MyApplicationTheme {
            Column {
                SimpleCoroutineButton()
                AsyncAwaitButton()
            }

        }
    }
}