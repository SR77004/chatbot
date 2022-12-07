package com.codepalace.chatbot.utils

import com.codepalace.chatbot.utils.Constants.OPEN_GOOGLE
import com.codepalace.chatbot.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {


            //Hello
            message.contains("hello") -> {
                when (random) {
                    0 -> "Hello there!"
                    1 -> "Sup"
                    2 -> "Hey!!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm bored"
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }
            //Planet earth
            message.contains("Which planet are in between Earth and the sun") -> {
                when (random) {
                    0 -> "Mercury and Venus"
                    1 -> "Venus and Mercury"
                    2 -> "I don't know"
                    else -> "error"
                }
            }
            //earth radius
            message.contains("How big is Earth’s radius") -> {
                when (random) {
                    0 -> "4000 miles"
                    1 -> "6437 kilometer"
                    2 -> "6437376 meter"
                    else -> "error"
                }
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the program doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}