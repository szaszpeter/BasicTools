package com.example.myapplication.navigation.launchscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
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
    Column {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(stringResource(R.string.coroutine_sample_title))
                }
            }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
        Button(
            onClick = {
                Navigation.findNavController(view)
                    .navigate(R.id.action_menuFragment_to_coroutineFragment)
            },
            Modifier.padding(34.dp, 8.dp, 16.dp, 8.dp)
        ) {
            Text(text = stringResource(R.string.launch_coroutine_sample))
        }
    }
}

@Composable
fun JetpackSamples() {
    val view = LocalView.current
    Column {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(stringResource(R.string.jetpack_sample_title))
                }
            }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
        Button(onClick = {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_composeFragment)
        }, Modifier.padding(34.dp, 8.dp, 16.dp, 8.dp)) {
            Text(text = stringResource(R.string.launch_jetpack_sample))
        }
    }
}

@Composable
fun FlowSamples() {
    val view = LocalView.current
    Column {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(stringResource(R.string.flow_sample_title))
                }
            }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
        Button(onClick = {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_flowFragment)
        }, Modifier.padding(34.dp, 8.dp, 16.dp, 8.dp)) {
            Text(text = stringResource(R.string.launch_flow_sample))
        }
    }
}

@Composable
fun PagerSample() {
    val view = LocalView.current
    Column {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(stringResource(R.string.pager_sample_title))
                }
            }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
        Button(onClick = {
            Navigation.findNavController(view).navigate(R.id.action_menuFragment_to_pagerFragment)
        }, Modifier.padding(34.dp, 8.dp, 16.dp, 8.dp)) {
            Text(text = stringResource(R.string.launch_pager_sample))
        }
    }
}

@Composable
fun ThreadPoolSample() {
    val view = LocalView.current
    Column {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append(stringResource(R.string.threadpool_sample_title))
                }
            }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
        Button(onClick = {
            Navigation.findNavController(view)
                .navigate(R.id.action_menuFragment_to_threadPoolFragment)
        }, Modifier.padding(34.dp, 8.dp, 16.dp, 8.dp)) {
            Text(text = stringResource(R.string.launch_threadpool_sample))
        }
    }

}