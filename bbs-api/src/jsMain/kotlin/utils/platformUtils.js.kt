package com.elouyi.sbboyohim.utils

import kotlin.js.Date


public actual fun currentTimeMillis(): Long {
    return Date().getTime().toLong()
}
