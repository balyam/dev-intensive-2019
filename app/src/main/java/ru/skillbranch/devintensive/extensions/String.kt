package ru.skillbranch.devintensive.extensions

fun String.truncate(number:Int = 16): String{
        var strTruncate = if (this.length > number)
                this.removeRange(number until this.length) else return this
        return if (strTruncate.trim().length < strTruncate.length) strTruncate.trim().plus("...")
                else strTruncate.plus("...")

}