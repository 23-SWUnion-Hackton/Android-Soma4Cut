package com.staker4wapper.data.mapper

import com.staker4wapper.data.remote.dto.auth.SignupRequestDto
import com.staker4wapper.data.remote.dto.auth.SignupResponseDto
import com.staker4wapper.domain.model.auth.SignupRequestModel
import com.staker4wapper.domain.model.auth.SignupResponseModel

fun SignupRequestModel.toDto() = SignupRequestDto(
    name = this.name,
    password = this.password
)

fun SignupResponseDto.toModel() = SignupResponseModel(
    message = this.message,
    status = this.status
)