package com.example.plugins

import com.example.dataBase.userManager.reristrationBlock
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {


    routing {
        get("/") {
            println("hello")
            call.respondText("Hello World!")
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
    reristrationBlock()
}
