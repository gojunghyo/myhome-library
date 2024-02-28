package com.myhome.library.utils


fun fail(message: String): Nothing {
    throw IllegalArgumentException("$message")
}
