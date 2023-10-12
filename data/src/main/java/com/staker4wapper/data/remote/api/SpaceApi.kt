package com.staker4wapper.data.remote.api

import com.staker4wapper.data.remote.dto.space.PostImageResponseDto
import com.staker4wapper.domain.model.space.Image
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SpaceApi {

    @GET("/user/soma-space")
    suspend fun getSomaSpaceImages(): List<Image>

    @POST("/user/soma-space/{code}")
    suspend fun postSomaSpaceImage(
        @Path("code") code: String
    ): PostImageResponseDto

}