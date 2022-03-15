package com.example.front

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.css.map

fun Route.homePage(){
    get("/testfree") {
        call.respond(FreeMarkerContent("index.ftl", map))
    }
}

fun Application.homePageRouting(){
    routing { homePage() }
}