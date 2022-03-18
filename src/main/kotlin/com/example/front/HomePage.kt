package com.example.front

import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.css.map
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


fun Route.homePage(){
    get("/front") {
        call.respond(FreeMarkerContent("front.ftl", map))
    }
}

fun Application.homePageRouting(){
    routing { homePage() }
}