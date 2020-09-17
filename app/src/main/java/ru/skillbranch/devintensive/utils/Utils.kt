package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?>{
        var parts: List<String>? = fullName?.split(" ", limit = 2)
        var firstName: String? = if(parts?.getOrNull(0)?.length?:0 == 0) null else parts?.getOrNull(0)
        var lastName: String? = if(parts?.getOrNull(1)?.length?:0 == 0) null else parts?.getOrNull(1)
        return firstName to lastName
    }
}