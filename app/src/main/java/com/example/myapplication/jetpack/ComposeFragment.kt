package com.example.myapplication.jetpack

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapplication.R
import com.example.myapplication.flows.ui.theme.MyApplicationTheme
import com.example.myapplication.jetpack.data.Message
import com.example.myapplication.jetpack.data.SampleData
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ComposeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                MyApplicationTheme(true) {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        ScreenContent()
                    }
                }
            }
        }
    }

    @Composable
    fun ScreenContent() {
        Conversation(messages = SampleData.conversationSample)
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                Surface(
                    shape = MaterialTheme.shapes.medium, elevation = 1.dp,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Structure(message)
                }
            }
        }
    }

    @Composable
    fun Structure(message: Message) {
        Row {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "small icon",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(48.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
            )

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded })
            {
                Person(name = message.title)
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    // surfaceColor color will be changing gradually from primary to surface
                    color = surfaceColor,
                    // animateContentSize will change the Surface size gradually
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    TextItem(name = message.body, isExpanded)
                }

            }
        }
    }

    @Composable
    fun Person(name: String) {
        Text(
            text = "$name",
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle1
        )
    }

    @Composable
    fun TextItem(name: String, isExpanded: Boolean) {
        Text(
            text = "$name",
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.body2,
            // If the message is expanded, we display all its content
            // otherwise we only display the first line
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
        )
    }
}