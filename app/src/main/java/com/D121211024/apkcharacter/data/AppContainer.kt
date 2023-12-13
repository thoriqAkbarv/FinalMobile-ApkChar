package com.D121211024.apkcharacter.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.D121211024.apkcharacter.data.repository.FactsRepository
import com.D121211024.apkcharacter.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val factsRepository: FactsRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://api-blue-archive.vercel.app/"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val factsRepository: FactsRepository
        get() = FactsRepository(retrofitService)

}