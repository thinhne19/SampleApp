package com.example.simpleapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

// Định nghĩa class
data class Todo(
    var id: Int,
    var title: String,
    var createAt: Date
)

// Hàm giả lập dữ liệu
@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTodo(): List<Todo> {
    return listOf(
        Todo(id = 1, title = "Wow, That's day its not good", Date.from(Instant.now())),
        Todo(id = 2, title = "I don't know why I type that", Date.from(Instant.now())),
        Todo(id = 3, title = "He he he he he ", Date.from(Instant.now())),
        Todo(id = 4, title = "Huhuhuhuhuhu", Date.from(Instant.now()))
    )
}
