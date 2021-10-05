package com.elouyi.sbboyohim.internal.repository

import com.elouyi.sbboyohim.data.model.BbsSignResponse
import com.elouyi.sbboyohim.data.repository.BbsRepository
import com.elouyi.sbboyohim.data.utils.BbsRequestUrl
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*


internal class BbsRepositoryImpl(
    override val client: HttpClient
) : BbsRepository {

    override suspend fun bbsSign(
        uid: Int,
        cookieString: String,
        actId: String,
        region: String
    ): BbsSignResponse {
        val url = BbsRequestUrl.bbsSign(uid, actId, region)
        return client.get(url) {
            headers[HttpHeaders.Cookie] = cookieString
        }
    }
}