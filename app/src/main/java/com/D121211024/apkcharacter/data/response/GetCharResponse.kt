package com.D121211024.apkcharacter.data.response

import com.D121211024.apkcharacter.data.model.Data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCharResponse(
    @SerialName("data")
    val data: List<Data>,
    @SerialName("dataAllPage")
    val dataAllPage: Int?,
    @SerialName("message")
    val message: String?
)