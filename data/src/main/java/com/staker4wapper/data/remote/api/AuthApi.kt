package com.staker4wapper.data.remote.api

import com.staker4wapper.data.remote.dto.auth.SignupRequestDto
import com.staker4wapper.data.remote.dto.auth.SignupResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/auth/sign-up")
    suspend fun signup(
        @Body signupRequestDto: SignupRequestDto
    ): SignupResponseDto

}