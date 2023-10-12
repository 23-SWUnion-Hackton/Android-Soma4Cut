package com.staker4wapper.domain.model.auth

import java.time.LocalDateTime

data class LoginResponseModel(
    val accessToken: String,
    val refreshToken: String,
)