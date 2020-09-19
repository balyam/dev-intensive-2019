package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    operator fun times(value: Long): Long{
        return value * when(this){
            SECOND -> 1000L
            MINUTE -> SECOND * 60
            HOUR -> MINUTE * 60
            DAY -> HOUR * 24
        }
    }
}

@Throws(IllegalStateException::class)
fun Date.humanizeDiff(date: Date=Date()) : String {
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

fun Date.add(value: Long, timeUnit: TimeUnits): Date{
    var time = this.time
    time += timeUnit * value
    this.time = time
    return this
}

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}