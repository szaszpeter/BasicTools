package com.example.myapplication.navigation.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalView
import androidx.navigation.Navigation
import com.example.myapplication.R

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MenuContent()
            }
        }
    }

    @Composable
    fun MenuContent() {
        Column {
            CoroutineSamples()
            JetpackSamples()
            FlowSamples()
        }
    }

    @Composable
    fun CoroutineSamples() {
        val view = LocalView.current
        Button(onClick = {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_coroutineFragment)
        }) {
            Text(text = "Launch Coroutine Sample")
        }
    }
    @Composable
    fun JetpackSamples() {
        val view = LocalView.current
        Button(onClick = {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_composeFragment)
        }) {
            Text(text = "Launch Jetpack Sample")
        }
    }
    @Composable
    fun FlowSamples() {
        val view = LocalView.current
        Button(onClick = {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_flowFragment)
        }) {
            Text(text = "Launch Flow Sample")
        }
    }
}