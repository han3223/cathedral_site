package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.jetbrains.exposed.sql.Database
import java.sql.DriverManager


fun main() {
    embeddedServer(Netty, port = System.getenv()["PORT"]?.toInt() ?: 8080, host = System.getenv()["HOST"] ?: "localhost") {
        configureRouting()
        configureTemplating()
        configureSecurity()
    }.start(wait = true)
    Database.connect(
        "jdbc:h2:mem:test", driver = "org.h2.Driver",
        user = "root", password = "root")
    Database.connect({DriverManager.getConnection("jdbc:h2:mem:test;MODE=MySQL")})


}
