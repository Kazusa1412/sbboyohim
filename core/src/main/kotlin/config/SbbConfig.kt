package com.elouyi.sbboyohim.config

import com.elouyi.sbboyohim.feature.BbsSign
import org.yaml.snakeyaml.Yaml
import java.io.File


object SbbConfig {

    val configMap: Map<String,Any>

    init {
        File("config/config.yml").apply {
            configMap = if (exists()) Yaml().load(inputStream()) else mapOf()
        }
    }

    fun configMainArgs(args: Array<String>) {
        if (args.isEmpty()) return
        val delayMills = try {
            args[0].toLong()
        } catch (e: Exception) {
            return
        }
        println("今日延迟签到 $delayMills ms")
        BbsSign.firstDelayMills = delayMills
    }
}