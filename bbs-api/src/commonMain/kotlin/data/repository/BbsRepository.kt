package com.elouyi.sbboyohim.data.repository

import com.elouyi.sbboyohim.Bot
import com.elouyi.sbboyohim.data.model.BbsSignInfoResponse
import com.elouyi.sbboyohim.data.model.BbsSignResponse
import io.ktor.client.*


public interface BbsRepository {

    public val client: HttpClient

    public suspend fun bbsSign(
        uid: Int,
        cookieString: String,
        actId: String = "e202009291139501",
        region: String = "cn_gf01"
    ): BbsSignResponse

    public suspend fun bbsSign(
        bot: Bot,
        actId: String = "e202009291139501",
    ): BbsSignResponse = bbsSign(bot.uid, bot.cookieString, actId, bot.region)

    public suspend fun bbsSignInfo(
        uid: Int,
        cookieString: String,
        actId: String = "e202009291139501",
        region: String = "cn_gf01"
    ): BbsSignInfoResponse

    public suspend fun bbsSignInfo(
        bot: Bot,
        actId: String = "e202009291139501"
    ): BbsSignInfoResponse = bbsSignInfo(bot.uid, bot.cookieString, actId, bot.region)
}
