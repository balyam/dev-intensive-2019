package ru.skillbranch.devintensive.models

import org.junit.Test

import org.junit.Assert.*
import org.w3c.dom.Text
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
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
        println("firstname = ${user.firstName} , lastname = ${user.lastName}")
    }

    @Test
    fun test_add_date(){
        var addMinute = Date().add(34, TimeUnits.MINUTE)
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

}