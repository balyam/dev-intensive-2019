package ru.skillbranch.devintensive.models

import org.junit.Test

import org.junit.Assert.*
import org.w3c.dom.Text
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.utils.Utils
import java.time.LocalDateTime
import java.util.*

class BaseMessageTest {

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Esekei Omar")
        val txtMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "txt message", type = "text" )
        val imgMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "image message", type = "image")

      println(txtMessage.formatMessage())
      println(imgMessage.formatMessage())
    }

    @Test
    fun test_humanizeDiff(){
        val user = User.makeUser("Esekei Omar")
        var nowdate = Date().time - 120000
        var testdate = Date(nowdate)
        val txtMessage = BaseMessage.makeMessage(user, Chat("1"), date = testdate, payload = "txt message", type = "text" )
        val txtMessage2 = BaseMessage.makeMessage(user, Chat("1"), isIncoming = true, payload = "txt message", type = "text" )
        val imgMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "image message", type = "image" )
        println(txtMessage.formatMessage())
        println(txtMessage2.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_add_date(){
        var addMinute = Date().add(34, TimeUnits.MINUTE).humanizeDiff()
        var addDay = Date().add(2, TimeUnits.DAY)
        println(addMinute)
        println(addDay)
    }

    @Test
    fun test_initials(){
        //var firstname = "Esekei"
        var pairList = listOf(
                Pair("esekei", "Omar"),
                Pair(null, "omar"),
                Pair("Esekei", null),
                Pair(null, null),
                Pair("","")
        )

        for(pair in pairList){
            println(Utils.toInitials(pair.first, pair.second))
        }


    }

    @Test
    fun test_user_builder(){
        val user = User.Builder().id("5")
                .firstName("Esekei")
                .lastName("Omar")
                .avatar("mount")
                .rating(5)
                .respect(7)
                .lastVisit(Date())
                .isOnline(true)
                .build()
        val user2 = User.Builder().id("7")
                .firstName("Tleuly")
                .rating(15)
                .build()
        println(user)
        println(user2)
    }

    @Test
    fun test_parse_full_name(){
        val nameParse = Utils.parseFullName("Esekei Omar")
        val nameParse2 = Utils.parseFullName("")
        val nameParse3 = Utils.parseFullName("Omar")
        val nameParse4 = Utils.parseFullName(" ")

        println(nameParse)
        println(nameParse2)
        println(nameParse3)
        println(nameParse4)
    }

    @Test
    fun test_truncate(){
        var trstr = "1234567890abcdefghijk".truncate(16)
        var trstr2 = "1234   jhgksad".truncate(5)
        var trstr3 = "12345    ".truncate(3)

        println("${trstr.length} $trstr")
        println("${trstr2.length} $trstr2")
        println("${trstr3.length} $trstr3")

    }

    @Test
    fun test_date_format(){
        var dateFormat = Date().format()
        var dateFormat2 = Date().format("HH:mm:ss")

        println(dateFormat)
        println(dateFormat2)
    }

}