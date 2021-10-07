package com.elouyi.sbboyohim.utils

import io.ktor.utils.io.core.*


public expect object MD5Util {

    public fun md5(data: ByteArray): ByteArray
}

@Suppress("Nothing_To_Inline")
public inline fun MD5Util.md5(str: String): String = md5(str.toByteArray()).toHexString()

public inline val String.md5: String get() = MD5Util.md5(this)
