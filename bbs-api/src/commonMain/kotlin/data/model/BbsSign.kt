package com.elouyi.sbboyohim.data.model

import com.elouyi.sbboyohim.data.BbsResponse
import kotlinx.serialization.Serializable

@Serializable
public data class BbsSignResponse(
    override val retcode: Int,
    override val message: String,
    override val data: BbsSignData?
) : BbsResponse<BbsSignData?>

@Serializable
public data class BbsSignData(
    val code: String
)
