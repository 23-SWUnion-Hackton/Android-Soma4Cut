package com.staker4wapper.data.repository

import com.staker4wapper.data.mapper.toDto
import com.staker4wapper.data.mapper.toModel
import com.staker4wapper.data.remote.api.CodeApi
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.Codes
import com.staker4wapper.domain.model.code.SaveCodeRequestModel
import com.staker4wapper.domain.model.code.SaveCodeResponseModel
import com.staker4wapper.domain.repository.CodeRepository
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val codeApi: CodeApi
): CodeRepository {

    override suspend fun getCodes(): List<Code> {
        return codeApi.getCodes()
    }

    override suspend fun searchCode(code: String): Code =
        codeApi.searchCode(code)

    override suspend fun saveCode(saveCodeRequestModel: SaveCodeRequestModel): SaveCodeResponseModel =
        codeApi.saveCode(saveCodeRequestModel.toDto()).toModel()



}