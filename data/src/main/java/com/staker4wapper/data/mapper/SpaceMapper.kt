package com.staker4wapper.data.mapper

import com.staker4wapper.data.remote.dto.space.PostImageResponseDto
import com.staker4wapper.domain.model.space.PostImageResponseModel

fun PostImageResponseDto.toModel() = PostImageResponseModel(
    message = this.message,
    status = this.status
)