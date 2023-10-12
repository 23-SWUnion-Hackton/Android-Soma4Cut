package com.staker4wapper.domain.repository

import com.staker4wapper.domain.model.auth.SignupRequestModel
import com.staker4wapper.domain.model.auth.SignupResponseModel

interface AuthRepository {

    suspend fun signup(
        signupRequestModel: SignupRequestModel
    ): SignupResponseModel

}