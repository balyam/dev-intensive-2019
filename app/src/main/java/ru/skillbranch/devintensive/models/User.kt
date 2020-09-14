package ru.skillbranch.devintensive.models

import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String? = null,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date = Date(),
    var isOnline: Boolean = false
    ) {
    companion object UserFactory{
        private var lastId: Int = -1
        fun makeUser(fullName: String?) : User{
            lastId ++
            var parts: List<String>? = fullName?.split(" ")
            var firstName: String? = parts?.getOrNull(0)
            var lastName: String? = parts?.getOrNull(1)
            return User("$lastId", lastName = lastName, firstName = firstName )
        }
    }
}