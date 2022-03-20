package com.example.dataBase.inputRegistration

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.p
import loginUser

fun Route.checkUser() {
    post("/qwert") {
        val params = call.receiveParameters()
        val login = params["login"] ?: return@post call.respond(HttpStatusCode.BadRequest)
        val pas = params["pas"] ?: return@post call.respond(HttpStatusCode.BadRequest)
        loginUser(login, pas)
        if (loginUser(login, pas) != "") {
            call.respondHtml {
                body {
                    p { h1 { +"Привет ${loginUser(login, pas)}" } }
                }
            }
        }
    }
}

fun Application.check() {
    routing { checkUser() }
}