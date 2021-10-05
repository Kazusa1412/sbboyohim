package com.elouyi.sbboyohim.internal

import com.elouyi.sbboyohim.Bot
import com.elouyi.sbboyohim.data.repository.BbsRepository


internal class AppBot(
    override val repository: BbsRepository,
    override val uid: Int,
    override val region: String,
) : Bot {
    override lateinit var cookieString: String
}
