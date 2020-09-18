package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        var parts: List<String>? = fullName?.split(" ", limit = 2)
        var firstName: String? = if(parts?.getOrNull(0)?.length?:0 == 0) null else parts?.getOrNull(0)
        var lastName: String? = if(parts?.getOrNull(1)?.length?:0 == 0) null else parts?.getOrNull(1)
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName:String?): String?{
        var first: String? = if(firstName?.length == 0) null else firstName?.capitalize()?.get(0).toString()
        var last: String? =  if(lastName?.length == 0) null else lastName?.capitalize()?.get(0).toString()
        //var summary:String? = first ?: "" + last ?: ""
        var summary = StringBuilder()

        return "${summary.append(first).append(last)}"

    }

//    fun transliteration(payload:String?, divider:String = " "): String? {
//        return "pass"
//    }
}