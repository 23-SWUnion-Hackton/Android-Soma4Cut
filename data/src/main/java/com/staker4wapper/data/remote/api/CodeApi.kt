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
 * [Code(code=75EwXbQg, createdAt=2023-10-13T00:59:13.331425, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/XbVMMVmM.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/QjTEXtMr.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/bzfTA1P8.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/XqG02hQX.jpeg]),
 * Code(code=xPWcfkNz, createdAt=2023-10-13T01:03:51.47621, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/KH7YdxNi.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/eUtHZv4L.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/aQCexmbw.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/1uRowxo5.jpeg]),
 * Code(code=fJ446lH2, createdAt=2023-10-13T01:32:23.71838, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/2yQosXZj.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/2sJvdOb6.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/oGv6NK6I.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/pD8BOg6J.jpeg]),
 * Code(code=NZTdNAhI, createdAt=2023-10-13T01:38:55.738659, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/NZTdNAhI.jpeg]), Code(code=C47kyzKi, createdAt=2023-10-13T01:39:23.391373, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/C47kyzKi.jpeg]), Code(code=5nioT0Uo, createdAt=2023-10-13T01:41:00.205206, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/5nioT0Uo.jpeg]), Code(code=2ES6DUkn, createdAt=2023-10-13T01:47:30.940237, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/Fkt046fA.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/Ent9BpPB.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/67Xro6rt.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/hQ15dQMY.jpeg]), Code(code=1SlCHKph, createdAt=2023-10-13T01:49:05.938107, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/1SlCHKph.jpeg]), Code(code=OREF99cu, createdAt=2023-10-13T02:13:42.869481, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/g1FKPGXm.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/CNXBFZLD.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/KPGBpymC.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/sz4k5MYX.jpeg]), Code(code={
 *                                                                                                         "code": "75EwXbQg"
 *                                                                                                     }, createdAt=2023-10-13T03:53:25.362655, image=[]), Code(code={"code":"C47kyzKi"}, createdAt=2023-10-13T04:13:09.995966, image=[])]
 *                                                                                                     */