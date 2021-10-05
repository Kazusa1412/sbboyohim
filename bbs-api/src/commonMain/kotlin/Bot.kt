package com.elouyi.sbboyohim

import com.elouyi.sbboyohim.data.model.BbsSignResponse
import com.elouyi.sbboyohim.data.repository.BbsRepository

public expect fun Bot(
    uid: Int,
    region: String = "cn_gf01"
): Bot

public fun Bot(
    uid: Int,
    cookieString: String,
    region: String = "cn_gf01"
): Bot {
    return Bot(uid = uid,region = region).apply {
        this.cookieString = cookieString
    }
}

public interface Bot {

    public val repository: BbsRepository

    public val uid: Int

    public val region: String

    public var cookieString: String
}

public suspend fun Bot.bbsSign(): BbsSignResponse {
    return repository.bbsSign(this)
}
