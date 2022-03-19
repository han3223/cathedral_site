package com.example.plugins

import com.example.dataBase.registrationUser.addNewUser
import com.example.dataBase.registrationUser.check
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
    homePageRouting()
}
