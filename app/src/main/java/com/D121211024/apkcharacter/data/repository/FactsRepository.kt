package com.D121211024.apkcharacter.data.repository

import com.D121211024.apkcharacter.data.response.GetCharResponse
import com.D121211024.apkcharacter.data.source.remote.ApiService

class FactsRepository(private val apiService: ApiService) {

    suspend fun getFacts(): GetCharResponse {
        return apiService.getFacts()
    }
}