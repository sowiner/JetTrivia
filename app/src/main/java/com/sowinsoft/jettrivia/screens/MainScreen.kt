package com.sowinsoft.jettrivia.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sowinsoft.jettrivia.ui.theme.JetTriviaTheme


@Composable
fun MainScreen(content: @Composable (modifier: Modifier) -> Unit) {
    JetTriviaTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            content(Modifier.padding(innerPadding))
        }
    }
}