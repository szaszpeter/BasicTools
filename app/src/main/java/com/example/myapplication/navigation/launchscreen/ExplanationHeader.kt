package com.example.myapplication.navigation.launchscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExplanationHeader() {
    Column {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray, fontSize = 28.sp)) {
                    append("Welcome")
                }
            }, modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 0.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 28.sp)) {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Hola and welcome to ")
                    }

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    ) {
                        append("BasicTools! \n")
                    }
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("This is the ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Green
                        )
                    ) {
                        append("LauncherActivity ")
                    }
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("and you can find it under the 'navigation' package.")
                    }
                }
            },
            modifier = Modifier.padding(16.dp)
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Gray, fontSize = 18.sp, fontWeight = FontWeight.Bold)) {
                    append("Here's what you will learn: ")
                }
            }, modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp)
        )
    }
}