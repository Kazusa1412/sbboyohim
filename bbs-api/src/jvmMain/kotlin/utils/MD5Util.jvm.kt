package com.elouyi.sbboyohim.utils

import java.security.MessageDigest


public actual object MD5Util {

    public actual fun md5(data: ByteArray): ByteArray {
        val md = MessageDigest.getInstance("MD5")
        return md.run {
            update(data)
            digest()
        }
    }
}