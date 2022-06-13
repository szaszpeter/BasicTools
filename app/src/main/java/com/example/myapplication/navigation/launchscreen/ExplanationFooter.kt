package com.example.myapplication.navigation.launchscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun ExplanationFooter() {
    Column {
        ExplanationFooterTitle()
        NavigationComponentSection()
        KoinDISection()
        CircleCISection()
        EspressoSection()
    }
}

@Composable
fun ExplanationFooterTitle() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(stringResource(R.string.explanation_footer_title))
            }
        }, modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
    )
}

@Composable
fun NavigationComponentSection() {
    Text(
        text = "1. Navigation Component",
        modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 0.dp),
        color = Color.Gray, fontWeight = FontWeight.Bold
    )
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 28.sp)) {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("To understand how the navigation is achieved in this app, refer to the ")
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                ) {
                    append("res/navigation/navigation.xml ")
                }
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("file. ")
                }
            }
        },
        modifier = Modifier.padding(32.dp, 16.dp, 0.dp, 0.dp)
    )
}

@Composable
fun KoinDISection() {
    Text(
        text = "2. Dependency Injection with Koin",
        modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 0.dp),
        color = Color.Gray, fontWeight = FontWeight.Bold
    )
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 28.sp)) {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("By looking into the sample classes provided in the ")
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                ) {
                    append("koin ")
                }
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("package, you can see a basic model of how to set up and configure your app classes with Koin. The by default method in this app will be Hilt, as per now it is more widely adopted by developers across the world. ")
                }
            }
        },
        modifier = Modifier.padding(32.dp, 16.dp, 0.dp, 0.dp)
    )
}

@Composable
fun CircleCISection() {
    Text(
        text = "3. Continuous Integration with CircleCI",
        modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 0.dp),
        color = Color.Gray, fontWeight = FontWeight.Bold
    )
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 28.sp)) {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("This project is configured with CircleCI. Compared to Jenkins it is a much more convenient method to run your automation. The ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                ) {
                    append(".circleci ")
                }
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("package, package contains the ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                ) {
                    append(".config.yml ")
                }
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("file. Here you will see how to configure jobs, workflows, run tests, deploy build artifacts, etc. ")
                }
            }
        },
        modifier = Modifier.padding(32.dp, 16.dp, 0.dp, 0.dp)
    )
}

@Composable
fun EspressoSection() {
    Text(
        text = "4. Compose UI Tests with Espresso",
        modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 0.dp),
        color = Color.Gray, fontWeight = FontWeight.Bold
    )
    Text(
        buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 28.sp)) {
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("As mentioned in the title, you can find a sample of UI Test made with Espresso, but with the catch of testing compose elements. You can find this test in the ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                ) {
                    append("/androidTest/ExampleInstrumentedTest ")
                }
                withStyle(style = SpanStyle(color = Color.Gray)) {
                    append("class. This test is also performed on the CircleCI automated job.")
                }
            }
        },
        modifier = Modifier.padding(32.dp, 16.dp, 0.dp, 0.dp)
    )
}