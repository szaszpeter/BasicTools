package com.example.myapplication.navigation.mainmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.navigation.Navigation
import com.example.myapplication.R

@Composable
fun MenuContent() {
    Column {
        CoroutineSamples()
        JetpackSamples()
        FlowSamples()
        PagerSample()
        ThreadPoolSample()
    }
}

@Composable
fun CoroutineSamples() {
    val view = LocalView.current
    Button(onClick = {
        Navigation.findNavController(view)
            .navigate(R.id.action_menuFragment_to_coroutineFragment)
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

@Composable
fun PagerSample() {
    val view = LocalView.current
    Button(onClick = {
        Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_pagerFragment)
    }) {
        Text(text = "Pager Sample")
    }
}

@Composable
fun ThreadPoolSample() {
    val view = LocalView.current
    Button(onClick = {
        Navigation.findNavController(view)
            .navigate(R.id.action_menuFragment_to_threadPoolFragment)
    }) {
        Text(text = "ThreadPool Sample")
    }
}