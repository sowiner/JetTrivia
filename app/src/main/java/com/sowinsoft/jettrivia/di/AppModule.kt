package com.sowinsoft.jettrivia.di

import com.sowinsoft.jettrivia.api.QuestionApi
import com.sowinsoft.jettrivia.repository.QuestionRepository
import com.sowinsoft.jettrivia.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi): QuestionRepository = QuestionRepository(api)


    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuestionApi::class.java)
}