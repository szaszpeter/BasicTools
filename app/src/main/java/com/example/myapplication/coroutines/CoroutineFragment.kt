package com.example.myapplication.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class CoroutineFragment : Fragment() {

    private val viewModel: CoroutineViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                ScreenContent()
            }
        }
    }

    @Composable
    fun ScreenContent() {
        Column {
            SimpleCoroutineButton()
            AsyncAwaitButton()
            AsyncAwaitAllButton()
            CoroutineScopeButton()
            JobExampleButton()
            CoroutineContextExampleButton()
            InjectedDispatcherExample()
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

    @Composable
    fun InjectedDispatcherExample() {
        Button(onClick = {
            viewModel.injectedDispatcherExample()
        }) {
            Text(text = "Injected Dispatcher")
        }
    }

}