package com.example.plugins

import com.example.dataBase.userManager.reristrationBlock
import com.example.front.homePageRouting
import io.ktor.routing.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.configureRouting() {


    routing {
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
    reristrationBlock()
    homePageRouting()
}
