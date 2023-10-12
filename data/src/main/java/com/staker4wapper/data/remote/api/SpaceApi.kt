package com.staker4wapper.data.remote.api

import com.staker4wapper.domain.model.space.Image
import retrofit2.http.GET

interface SpaceApi {

    @GET("/user/soma-space")
    suspend fun getSomaSpaceImages(): List<Image>

}