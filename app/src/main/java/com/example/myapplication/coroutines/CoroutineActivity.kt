package com.example.myapplication.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                    SimpleButton()
                }
            }
        }
    }


    @Composable
    fun SimpleButton() {
        Button(onClick = {
            viewModel.launchSampleCoroutine("User", "token")
        }) {
            Text(text = "Launch Coroutine")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        MyApplicationTheme {
            SimpleButton()
        }
    }
}