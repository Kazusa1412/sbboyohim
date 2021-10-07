package com.elouyi.sbboyohim.internal.utils

import com.elouyi.sbboyohim.utils.currentTimeSeconds
import com.elouyi.sbboyohim.utils.md5


internal object BbsUtils {

    private const val constString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    fun getDs(salt: String = "h8w582wxwgqvahcdkpvdhbh2w9casgfl"): String {
        val t = currentTimeSeconds()
        val r = randomStr(6)
        return buildString {
            append(t).append(",")
            append(r).append(",")
            append("salt=$salt&t=$t&r=$r".md5)
        }
    }

    fun randomSingleStr(): String {
        return constString.random().toString()
    }

    fun randomStr(n: Int): String = buildString {
        repeat(n) {
            append(randomSingleStr())
        }
    }

}