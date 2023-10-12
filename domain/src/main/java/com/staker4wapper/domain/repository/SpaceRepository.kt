package com.staker4wapper.domain.repository

import com.staker4wapper.domain.model.space.Image
import com.staker4wapper.domain.model.space.PostImageResponseModel

interface SpaceRepository {

    suspend fun getSomaSpaceImages(): List<Image>

    suspend fun postSomaSpaceImage(
        code: String
    ): PostImageResponseModel

}