package com.staker4wapper.domain.model.code

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Code(
    val code: String,
    val createdAt: String,
    val image: String
): Parcelable
