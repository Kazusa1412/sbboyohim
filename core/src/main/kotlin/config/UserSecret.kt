package com.elouyi.sbboyohim.config


data class UserSecret(
    val uid: Int,
    val cookies: String
) {
    companion object {
        val list: List<UserSecret> by lazy {
            try {
                (SbbConfig.configMap["bots"] as List<Map<String,Any>>).map {
                    UserSecret(it["uid"].toString().toInt(), it["cookies"].toString())
                }
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}
