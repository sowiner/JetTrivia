package com.sowinsoft.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sowinsoft.jettrivia.components.QuestionSection
import com.sowinsoft.jettrivia.screens.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen { modifier, viewModel ->
                QuestionSection(modifier = modifier, viewModel = viewModel)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen { modifier, viewModel ->
        QuestionSection(modifier = modifier, viewModel = viewModel)

    }
}