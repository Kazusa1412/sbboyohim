package com.elouyi.sbboyohim

import com.elouyi.sbboyohim.internal.AppBot
import com.elouyi.sbboyohim.internal.repository.BbsRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

public actual fun Bot(
    uid: Int,
    region: String
): Bot {
    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(UserAgent) {
            agent = "Mozilla/5.0 (Linux; Android 11; MI 8 Build/RQ2A.210505.003; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/90.0.4430.82 Mobile Safari/537.36 miHoYoBBS/2.11.1"
        }
    }
    val repository = BbsRepositoryImpl(client)
    return AppBot(repository, uid, region)
}