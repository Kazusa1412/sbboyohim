package com.elouyi.sbboyohim.internal.repository

import com.elouyi.sbboyohim.data.model.BbsSignInfoResponse
import com.elouyi.sbboyohim.data.model.BbsSignResponse
import com.elouyi.sbboyohim.data.repository.BbsRepository
import com.elouyi.sbboyohim.data.utils.BbsRequestUrl
import com.elouyi.sbboyohim.internal.BbsConfig
import com.elouyi.sbboyohim.internal.utils.BbsUtils
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


internal class BbsRepositoryImpl(
    override val client: HttpClient
) : BbsRepository {

    override suspend fun bbsSignInfo(
        uid: Int,
        cookieString: String,
        actId: String,
        region: String
    ): BbsSignInfoResponse {
        val url = BbsRequestUrl.bbsSignInfo(uid, actId, region)
        return client.get(url) {
            headers[HttpHeaders.Cookie] = cookieString
        }
    }

    override suspend fun bbsSign(
        uid: Int,
        cookieString: String,
        actId: String,
        region: String
    ): BbsSignResponse {
        val url = BbsRequestUrl.bbsSign()
        return client.post(url) {
            headers[HttpHeaders.Cookie] = cookieString
            headers["DS"] = BbsUtils.getDs()
            headers["x-rpc-client_type"] = BbsConfig.clientType
            headers["x-rpc-app_version"] = BbsConfig.appVersion
            headers["x-rpc-device_id"] = "290d1e93-b25a-3c6e-a80f-040e109c888c"
            headers["Content-Type"] = "application/json;charset=UTF-8"
            body = SignBody(uid.toString(), actId, region) // bbsSignBody(uid, actId, region)
        }
    }

    @Deprecated("")
    private fun bbsSignBody(
        uid: Int,
        actId: String,
        region: String
    ): String = buildString {
        append("{")
        append("\"act_id\":").append("\"$actId\"").append(",")
        append("\"region\":").append("\"$region\"").append(",")
        append("\"uid\":").append("\"$uid\"")
        append("}")
    }

    @Serializable
    private data class SignBody(
        val uid: String,
        @SerialName("act_id")
        val actId: String,
        val region: String
    )
}