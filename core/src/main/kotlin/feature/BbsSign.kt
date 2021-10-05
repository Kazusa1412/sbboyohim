package com.elouyi.sbboyohim.feature

import com.elouyi.sbboyohim.Bot
import com.elouyi.sbboyohim.bbsSign
import com.elouyi.sbboyohim.config.UserSecret
import com.elouyi.sbboyohim.data.model.BbsSignResponse
import kotlinx.coroutines.*
import java.util.concurrent.Executors


object BbsSign {

    var firstDelayMills = 0L

    private val ceh = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
    }

    private val scope by lazy {
        CoroutineScope(
            SupervisorJob()
            + Executors.newScheduledThreadPool(1) {
                Thread(it).apply { isDaemon = false }
            }.asCoroutineDispatcher()
            + ceh
        )
    }

    val bots by lazy {
        UserSecret.list.map {
            Bot(uid = it.uid, cookieString = it.cookies)
        }
    }

    fun startDailySign() {
        scope.launch {
            delay(firstDelayMills)
            while (true) {
                println("开始每日签到")
                for (bot in bots) {
                    val res = bot.bbsSign()
                    printSignResult(bot, res)
                }
                delay(1L * 24 * 60 * 60 * 998)
            }
        }
    }

    fun printSignResult(bot: Bot, res: BbsSignResponse) {
        if (res.retcode != 0) {
            System.err.println("uid: ${bot.uid} 签到失败")
            System.err.println(res)
            return
        }
        println("uid: ${bot.uid} 签到成功")
        println(res)
    }
}