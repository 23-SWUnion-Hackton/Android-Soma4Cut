package com.staker4wapper.domain.repository

import com.staker4wapper.domain.model.space.Image

interface SpaceRepository {

    suspend fun getSomaSpaceImages(): List<Image>

}