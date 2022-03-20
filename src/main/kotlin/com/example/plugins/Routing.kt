package com.example.plugins

import com.example.dataBase.inputRegistration.addNewUser
import com.example.dataBase.inputRegistration.check
import com.example.dataBase.inputRegistration.logedInUser
import com.example.front.homePageRouting
import io.ktor.routing.*
import io.ktor.http.content.*
import io.ktor.application.*

fun Application.configureRouting() {


    routing {
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
    addNewUser()
    check()
    logedInUser()
    homePageRouting()
}
