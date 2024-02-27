package com.myhome.library.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class LoggerSupportUtils {

    inline fun <reified T : Any> Logger.logger(): Logger = LoggerFactory.getLogger(T::class.java)
}
