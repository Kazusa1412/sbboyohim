package com.elouyi.sbboyohim.data.model

import com.elouyi.sbboyohim.data.BbsResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BbsSignResponse(
    override val retcode: Int,
    override val message: String,
    override val data: BbsSignData
) : BbsResponse<BbsSignData>

@Serializable
public data class BbsSignData(
    @SerialName("total_sign_day")
    val totalSignDay: Int,
    val today: String,
    @SerialName("is_sign")
    val isSign: Boolean,
    @SerialName("first_bind")
    val isFirstBind: Boolean,
    @SerialName("is_sub")
    val isSub: Boolean,
    @SerialName("month_first")
    val isMonthFirst: Boolean,
    @SerialName("sign_cnt_missed")
    val signCntMissed: Int
)
