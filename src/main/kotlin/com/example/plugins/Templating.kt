package com.example.plugins

import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*
import io.ktor.http.*
import freemarker.cache.*
import io.ktor.freemarker.*
import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.mustache.Mustache
import io.ktor.mustache.MustacheContent
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureTemplating() {


    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    install(Mustache) {
        mustacheFactory = DefaultMustacheFactory("templates/mustache")
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

data class IndexData(val items: List<Int>)
data class MustacheUser(val id: Int, val name: String)
