package com.staker4wapper.domain.repository

import com.staker4wapper.domain.model.space.Image
import com.staker4wapper.domain.model.space.PostImageResponseModel

interface SpaceRepository {

    suspend fun getSomaSpaceImages(): List<Image>

    suspend fun postSomaSpaceImage(
        code: String
    ): List<PostImageResponseModel>

}

/**
 * getCodes: success!! [
 * Code(code=u0HYrllq, createdAt=2023-10-13T07:53:26.415258, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/u0HYrllq.jpeg]),
 * Code(code=8sADsaVS, createdAt=2023-10-13T07:53:39.597367, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/8sADsaVS.jpeg]),
 * Code(code=A7p48Pra, createdAt=2023-10-13T07:54:59.606694, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/y0kEA0n3.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/iSiv35sn.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/bY4y7EDL.jpeg, https://soma-4cut.s3.ap-northeast-2.amazonaws.com/pd2LoezO.jpeg]),
 * Code(code=qbvfLFNV, createdAt=2023-10-13T08:20:37.077566, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/qbvfLFNV.jpeg]),
 * Code(code=EdHoFkhb, createdAt=2023-10-13T08:37:56.946987, image=[https://soma-4cut.s3.ap-northeast-2.amazonaws.com/EdHoFkhb.jpeg])]
 * */