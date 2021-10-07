package com.elouyi.sbboyohim.utils


public actual fun ByteArray.toHexString(): String = buildString {
    for (i in this@toHexString.indices) {
        val hex = Integer.toHexString(this@toHexString[i].toInt() and 0xff)
        if (hex.length < 2) append(0)
        append(hex)
    }
}

public actual fun String.hexToBytes(): ByteArray {
    var intHex = this
    var hexLen = this.length
    val result: ByteArray
    if (hexLen % 2 == 1) {
        hexLen++
        result = ByteArray(hexLen / 2)
        intHex = "0$intHex"
    } else {
        result = ByteArray(hexLen / 2)
    }
    for ((j, i) in (0 until hexLen step 2).withIndex()) {
        result[j] = Integer.parseInt(intHex.substring(i,i + 2),16).toByte()
    }
    return result
}
