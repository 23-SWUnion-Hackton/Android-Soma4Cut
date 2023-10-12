package com.staker4wapper.data.remote.api

import com.staker4wapper.domain.model.code.Code
import retrofit2.http.GET

interface CodeApi {

    @GET("/code")
    suspend fun getCodes(): List<Code>


}