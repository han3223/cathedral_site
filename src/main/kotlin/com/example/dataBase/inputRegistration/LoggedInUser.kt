package com.example.dataBase.inputRegistration

import io.ktor.application.*
import io.ktor.routing.*

fun Route.logedIn() {
    get("") {  }
}

fun Application.logedInUser() {
    routing { logedIn() }
}