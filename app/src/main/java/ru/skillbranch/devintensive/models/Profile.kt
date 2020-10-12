package ru.skillbranch.devintensive.models
/*
* Created at 12.10.2020
*/

data class Profile(
        val firstName: String,
        val lastName: String,
        val rank: String = "Junior Android Developer",
        val rating: Int=0,
        val respect: Int=0,
        val repository: String,
        val about: String
) {
    val nickName: String = "John Doe" //TODO

    fun toMap(): Map<String, Any> = mapOf(
           "nickName" to nickName,
            "firstName" to firstName ,
            "lastName" to lastName,
            "rank" to rank ,
            "rating" to rating ,
            "respect" to respect ,
            "repository" to repository ,
            "about" to about
    )

}