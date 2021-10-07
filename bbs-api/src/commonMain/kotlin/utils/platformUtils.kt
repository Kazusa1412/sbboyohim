package com.elouyi.sbboyohim.utils


public expect fun currentTimeMillis(): Long

public fun currentTimeSeconds(): Long = currentTimeMillis() / 1000
