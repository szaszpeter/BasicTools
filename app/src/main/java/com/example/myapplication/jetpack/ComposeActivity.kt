package com.example.myapplication.jetpack

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.jetpack.ui.theme.MyApplicationTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import com.example.myapplication.jetpack.data.Message
import com.example.myapplication.jetpack.data.SampleData

class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(messages = SampleData.conversationSample)
                }
            }
        }
    }
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

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Conversation(messages = SampleData.conversationSample)
    }
}