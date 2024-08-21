package com.sowinsoft.jettrivia.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sowinsoft.jettrivia.model.QuestionItem
import com.sowinsoft.jettrivia.screens.QuestionViewModel

@Composable
fun QuestionSection(modifier: Modifier = Modifier, viewModel: QuestionViewModel) {
val questions = viewModel.data.value.data?.toMutableList()
    LazyColumnQuestion(questions = questions, modifier = modifier)
}

@Composable
fun LazyColumnQuestion(questions: MutableList<QuestionItem>?, modifier: Modifier) {
    Log.d("SIZE", "LazyColumnQuestion: ${ questions?.size}")
}
