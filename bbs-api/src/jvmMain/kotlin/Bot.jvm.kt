package com.elouyi.sbboyohim

import com.elouyi.sbboyohim.data.repository.BbsRepository
import com.elouyi.sbboyohim.internal.AppBot
import com.elouyi.sbboyohim.internal.repository.BbsRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.cio.*
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
    }
    val repository = BbsRepositoryImpl(client)
    return AppBot(repository, uid, region)
}