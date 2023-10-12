package com.staker4wapper.data.repository

import com.staker4wapper.data.mapper.toDto
import com.staker4wapper.data.mapper.toModel
import com.staker4wapper.data.remote.api.AuthApi
import com.staker4wapper.data.remote.dto.auth.SignupRequestDto
import com.staker4wapper.data.remote.dto.auth.SignupResponseDto
import com.staker4wapper.domain.model.auth.SignupRequestModel
import com.staker4wapper.domain.model.auth.SignupResponseModel
import com.staker4wapper.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
): AuthRepository {

    override suspend fun signup(signupRequestModel: SignupRequestModel): SignupResponseModel =
        authApi.signup(signupRequestModel.toDto()).toModel()

}