package com.staker4wapper.domain.repository

import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.Codes
import com.staker4wapper.domain.model.code.SaveCodeRequestModel
import com.staker4wapper.domain.model.code.SaveCodeResponseModel

interface CodeRepository {

    suspend fun getCodes(): List<Code>

    suspend fun searchCode(
        code: String
    ): Code

    suspend fun saveCode(
        saveCodeRequestModel: SaveCodeRequestModel
    ): SaveCodeResponseModel

}