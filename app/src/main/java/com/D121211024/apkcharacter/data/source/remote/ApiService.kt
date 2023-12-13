package com.D121211024.apkcharacter.data.source.remote

import com.D121211024.apkcharacter.data.response.GetCharResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/characters")
    suspend fun getFacts(
    ): GetCharResponse
}