package com.sowinsoft.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sowinsoft.jettrivia.data.DataOrException
import com.sowinsoft.jettrivia.model.QuestionItem
import com.sowinsoft.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository) :
    ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getQuestions()
    }


    private fun getQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            try {
                data.value = repository.getAllQuestions()
                if (!data.value.data!!.toMutableList().isNullOrEmpty()) {
                    data.value.loading = false
                }
            } catch (e: Exception) {
                data.value.loading = false
                data.value.e = e
            }
        }
    }
}