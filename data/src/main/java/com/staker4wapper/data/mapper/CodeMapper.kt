package com.staker4wapper.data.mapper

import com.staker4wapper.data.remote.dto.code.SaveCodeRequestDto
import com.staker4wapper.data.remote.dto.code.SaveCodeResponseDto
import com.staker4wapper.domain.model.code.SaveCodeRequestModel
import com.staker4wapper.domain.model.code.SaveCodeResponseModel

fun SaveCodeRequestModel.toDto() = SaveCodeRequestDto(
    code = this.code
)

fun SaveCodeResponseDto.toModel() = SaveCodeResponseModel(
    message = this.message,
    status = this.status
)