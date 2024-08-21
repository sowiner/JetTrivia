package com.sowinsoft.jettrivia.repository

import android.util.Log
import com.sowinsoft.jettrivia.api.QuestionApi
import com.sowinsoft.jettrivia.data.DataOrException
import com.sowinsoft.jettrivia.model.QuestionItem
import javax.inject.Inject

//注入 api 依赖
class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private var listOfQuestions = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            listOfQuestions.loading = true
            listOfQuestions.data = api.getAllQuestions()
            if (listOfQuestions.data.toString().isNotEmpty()) {
                listOfQuestions.loading = false
            }
        } catch (e: Exception) {
            listOfQuestions.loading = false
            listOfQuestions.e = e
            Log.d("QuestionRepository ", "getAllQuestions: ${listOfQuestions.e!!.localizedMessage}")
        }
        return listOfQuestions
    }
}