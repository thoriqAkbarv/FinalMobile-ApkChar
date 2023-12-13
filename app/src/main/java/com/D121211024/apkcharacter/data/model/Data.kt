package com.D121211024.apkcharacter.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Data(
    val _id: String?,
    val birthday: String?,
    val damageType: String?,
    val image: String?,
    val imageSchool: String?,
    val name: String?,
    val photoUrl: String?,
    val school: String?
): Parcelable