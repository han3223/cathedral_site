package com.example.dataBase.userManager

import com.example.dataBase.model.UserModel
import com.example.dataBase.model.UserResponseModel
import io.ktor.application.*
import io.ktor.routing.*


fun Route.userRouting() {
    get() {  }
    post() {  }
    post() {  }
}

fun Application.reristrationBlock(){
    routing { userRouting() }
}

val userNoRegistration = UserResponseModel("", "", "", "")
val userRegistration = UserModel (1, "Важенин Иван Анатольевич", "ivan.vazhenin34@gmail.com", "ivan34", "qwerty123", 1234567890)