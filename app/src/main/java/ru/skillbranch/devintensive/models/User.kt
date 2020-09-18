package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
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
            var (firstName, lastName) = Utils.parseFullName(fullName)
            return User("$lastId", lastName = lastName, firstName = firstName )
        }
    }

    class Builder(
            var id: String = "",
            var firstName: String? = null,
            var lastName: String? = null,
            var avatar: String? = null,
            var rating: Int = 0,
            var respect: Int = 0,
            var lastVisit: Date = Date(),
            var isOnline: Boolean = false
    ){
        fun id(id:String) = apply { this.id = id }
        fun firstName(firstname: String?) = apply { this.firstName = firstname}
        fun lastName(lastname: String?) = apply { this.lastName = lastname }
        fun avatar(avatar: String?) = apply { this.avatar = avatar }
        fun rating(rating: Int) = apply { this.rating = rating}
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisit(lastvisit: Date) = apply { this.lastVisit = lastvisit }
        fun isOnline(isonline: Boolean) = apply { this.isOnline = isonline }
        fun build() = User(id, firstName, lastName, avatar, rating, respect, lastVisit, isOnline)
    }
}