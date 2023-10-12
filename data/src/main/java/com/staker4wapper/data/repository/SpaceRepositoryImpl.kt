package com.staker4wapper.data.repository

import com.staker4wapper.data.remote.api.SpaceApi
import com.staker4wapper.domain.model.space.Image
import com.staker4wapper.domain.repository.SpaceRepository
import javax.inject.Inject

class SpaceRepositoryImpl @Inject constructor(
    private val spaceApi: SpaceApi
): SpaceRepository {
    override suspend fun getSomaSpaceImages(): List<Image> =
        spaceApi.getSomaSpaceImages()

}