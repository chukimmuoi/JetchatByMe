package com.chukimmuoi.jetchatbyme.conversation

import androidx.compose.runtime.toMutableStateList
import com.chukimmuoi.jetchatbyme.R

/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: JetchatByMe
 * Created by chukimmuoi on 27/11/24.
 */
class ConversationUiState(
    val channelName: String,
    val channelMembers: Int,
    initialMessage: List<Message>
) {
    private val _messages: MutableList<Message> = initialMessage.toMutableStateList()
    val messages: List<Message> = _messages

    fun addMessage(msg: Message) {
        _messages.add(0, msg)
    }
}

data class Message(
    val author: String,
    val content: String,
    val timestamp: String,
    val image: Int? = null,
    val authorImage: Int = if (author == "me") R.drawable.ali else R.drawable.someone_else
)