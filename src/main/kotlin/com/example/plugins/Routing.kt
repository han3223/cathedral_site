package com.example.plugins

import com.example.dataBase.userManager.reristrationBlock
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.request.*
import kotlinx.html.body
import kotlinx.html.p

fun Application.configureRouting() {

    routing {
        get("/hello") { call.respondHtml {
            body {
                p { +"hello" }
            }
        } }
    }

    reristrationBlock()
}
