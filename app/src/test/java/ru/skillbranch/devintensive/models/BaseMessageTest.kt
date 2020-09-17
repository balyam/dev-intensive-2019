package ru.skillbranch.devintensive.models

import org.junit.Test

import org.junit.Assert.*
import org.w3c.dom.Text

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
        val txtMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "txt message", type = "text" )
        val txtMessage2 = BaseMessage.makeMessage(user, Chat("1"), isIncoming = true, payload = "txt message", type = "text" )
        println(txtMessage.formatMessage())
        println(txtMessage2.formatMessage())
    }

}