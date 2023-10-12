package com.staker4wapper.data.remote.dto.auth

import java.time.LocalDateTime

data class LoginResponseDto(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredAt: String,
    val refreshExpiredAt: String
)