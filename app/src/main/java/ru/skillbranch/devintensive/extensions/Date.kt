package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern

@Throws(IllegalStateException::class)
fun Date.humanizeDiff(date: Date) : String {
    val now = Date().time
    var interval = now - date.time
    var diff = (interval/1000).toInt()
    return when(diff){
        in 0..1  -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> "${diff/60} минут назад"
        in 2701..4500 -> "${diff/60} минут назад"
        in 4501..79200 -> "${diff/3600} час назад"
        else -> throw  IllegalStateException("unknown time")
    }

}