package com.staker4wapper.data.repository

import com.staker4wapper.data.mapper.toModel
import com.staker4wapper.data.remote.api.CodeApi
import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.Codes
import com.staker4wapper.domain.repository.CodeRepository
import javax.inject.Inject

class CodeRepositoryImpl @Inject constructor(
    private val codeApi: CodeApi
): CodeRepository {

    override suspend fun getCodes(): List<Code> {
        return codeApi.getCodes()
    }

}