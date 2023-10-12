package com.staker4wapper.domain.repository

import com.staker4wapper.domain.model.code.Code
import com.staker4wapper.domain.model.code.Codes

interface CodeRepository {

    suspend fun getCodes(): List<Code>

}