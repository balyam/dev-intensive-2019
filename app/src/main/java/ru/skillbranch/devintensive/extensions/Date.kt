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
    var dminute = diff/60
    var dhour = diff/3600
    var dday = diff/86400
    return when(diff){
        in 0..1  -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> if (dminute in 2..4) "$dminute минуты назад"  else "$dminute минут назад"
        in 2701..4500 -> "$dhour час назад"
        in 4501..79200 -> if (dhour in 2..4) "$dhour часа назад" else "$dhour часов назад"
        in 79201..93600 -> "$dday день назад"
        in 93601..31104000 -> if (dday in 2..4) "$dday дня назад" else "$dday дней назад"
        it > 31104001 -> "более года назад"
        else -> throw  IllegalStateException("unknown time")
    }

}