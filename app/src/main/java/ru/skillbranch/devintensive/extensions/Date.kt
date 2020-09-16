package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.util.*


@Throws(IllegalStateException::class)
fun Date.humanizeDiff(date: Date) : String {
    val now = Date().time
    val interval = now - date.time
    val diff = (interval/1000).toInt()
    val dminute = diff/60
    val dhour = diff/3600
    val dday = diff/86400
    return when(diff){
        in 0..1  -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> if (dminute in 2..4) "$dminute минуты назад"  else "$dminute минут назад"
        in 2701..4500 -> "$dhour час назад"
        in 4501..79200 -> if (dhour in 2..4) "$dhour часа назад" else "$dhour часов назад"
        in 79201..93600 -> "$dday день назад"
        in 93601..31104000 -> if (dday in 2..4) "$dday дня назад" else "$dday дней назад"
        in 31104001..Integer.MAX_VALUE -> "более года назад"
        else -> throw  IllegalStateException("unknown time")
    }

}