package com.staker4wapper.domain.model.code

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Code(
    val code: String,
    val createdAt: String,
    val image: List<String>
): Parcelable