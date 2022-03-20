package com.example.dataBase.inputRegistration

import addUser
import com.example.dataBase.model.AutorizationUser
import com.example.dataBase.model.emptyUser
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.css.map

    fun Route.newUser(){
        get("/qwerty") {
            call.respond(FreeMarkerContent("testform.ftl", map))
        }
        post("/qwerty") {
            val params = call.receiveParameters()
            val fio = params["fio"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val email = params["email"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val login = params["login"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val pass = params["pass"] ?: return@post call.respond(HttpStatusCode.BadRequest)
            val token = (1000000000 .. 9999999999).random()
            val newEntry = AutorizationUser(fio, email, login, pass, token.toString())
            emptyUser.add(0, newEntry)
            // TODO: send a status page to the user
            addUser()
            call.respond(FreeMarkerContent("testform.ftl", map))
        }
    }

    fun Application.addNewUser(){
        routing { newUser() }
    }