package com.staker4wapper.data.remote.api

import com.staker4wapper.data.remote.dto.code.SaveCodeRequestDto
import com.staker4wapper.data.remote.dto.code.SaveCodeResponseDto
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.Codes
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CodeApi {

    @GET("/code")
    suspend fun getCodes(): List<Code>

    @GET("/code/{code}")
    suspend fun searchCode(
        @Path("code") code: String
    ): Code

    @POST("/code")
    suspend fun saveCode(
        @Body saveCodeRequestDto: SaveCodeRequestDto
    ): SaveCodeResponseDto

}

/**
getCodes: success!! [
Code(code=u0HYrllq, createdAt=2023-10-13T07:53:26.415258, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/u0HYrllq.jpeg]), Code(code=8sADsaVS, createdAt=2023-10-13T07:53:39.597367, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/8sADsaVS.jpeg]),
Code(code=A7p48Pra, createdAt=2023-10-13T07:54:59.606694, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/y0kEA0n3.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/iSiv35sn.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/bY4y7EDL.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/pd2LoezO.jpeg]),
Code(code=A7p48Pra, createdAt=2023-10-13T07:55:52.393753, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/y0kEA0n3.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/iSiv35sn.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/bY4y7EDL.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/pd2LoezO.jpeg])]*/