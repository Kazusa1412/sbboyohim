package com.elouyi.sbboyohim.data


public interface BbsResponse<T> {

    public val retcode: Int

    public val message: String

    public val data: T
}
