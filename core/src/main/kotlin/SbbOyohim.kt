package com.elouyi.sbboyohim

import com.elouyi.sbboyohim.config.UserSecret
import com.elouyi.sbboyohim.feature.BbsSign
import kotlin.system.exitProcess


class SbbOyohim {

    init {
        println("bssoyohim started...")
        start()
    }

    private fun start() {
        checkUserInfo()
        BbsSign.startDailySign()
    }

    private fun checkUserInfo() {
        val list = UserSecret.list
        when {
            list.isEmpty() ->  end("没有找到需要签到的账号")
        }
        // todo
    }

    private fun end(message: String, exitCode: Int = 0) {
        System.err.println(message)
        println("按任意键继续")
        readLine()
        exitProcess(exitCode)
    }

}