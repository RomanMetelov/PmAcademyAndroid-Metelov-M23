package com.example.pmacademyandroid_metelov_m23.behavioral

import android.util.Log
import java.util.*

private const val STRATEGY_KEY = "STRATEGY_KEY"

val lowerCaseFormatter = { it: String -> it.toLowerCase(Locale.ROOT) }
val upperCaseFormatter = { it: String -> it.toUpperCase(Locale.ROOT) }

class Printer(private val stringFormatterStrategy: (String) -> String) {
    fun printString(string: String) = Log.d(STRATEGY_KEY, stringFormatterStrategy.invoke(string))
}

fun main() {
    val lowerCasePrinter = Printer(lowerCaseFormatter)
    lowerCasePrinter.printString("PrIfFfKi kAk DiLifFfKi")

    val upperCasePrinter = Printer(upperCaseFormatter)
    upperCasePrinter.printString("PrIfFfKi kAk DiLifFfKi")
}

