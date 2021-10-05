package com.elouyi.sbboyohim.data.utils


internal interface BbsRequestUrl {

    fun bbsSign(
        uid: Int,
        actId: String = "e202009291139501",
        region: String = "cn_gf01"
    ): String = buildString {
        append(https)
        append("api-takumi.mihoyo.com")
        append("/event/bbs_sign_reward/info?")
        append("act_id=$actId")
        append("&region=$region")
        append("&uid=$uid")
    }

    companion object : BbsRequestUrl {

        private val https = "https://"
    }
}