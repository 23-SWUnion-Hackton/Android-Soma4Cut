package com.staker4wapper.data.remote.api

import com.staker4wapper.data.remote.dto.auth.LoginRequestDto
import com.staker4wapper.data.remote.dto.auth.LoginResponseDto
import com.staker4wapper.data.remote.dto.auth.SignupRequestDto
import com.staker4wapper.data.remote.dto.auth.SignupResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/auth/sign-up")
    suspend fun signup(
        @Body signupRequestDto: SignupRequestDto
    ): SignupResponseDto

    @POST("/auth/sign-in")
    suspend fun login(
        @Body loginRequestDto: LoginRequestDto
    ): LoginResponseDto

}