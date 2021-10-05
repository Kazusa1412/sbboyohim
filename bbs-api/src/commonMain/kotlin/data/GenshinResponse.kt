package com.elouyi.sbboyohim.data


public interface GenshinResponse<T> {

    public val retcode: Int

    public val message: String

    public val data: T
}
