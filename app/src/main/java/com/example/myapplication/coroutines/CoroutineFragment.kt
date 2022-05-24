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
import com.example.myapplication.R
import com.example.myapplication.coroutines.CoroutineViewModel
import com.example.myapplication.koin.viewmodel.MyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CoroutineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoroutineFragment : Fragment() {

    // Lazy Inject ViewModel
    private val viewModel: CoroutineViewModel by viewModel()

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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment CoroutineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CoroutineFragment()
    }
}