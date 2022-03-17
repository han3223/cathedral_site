package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import org.jetbrains.exposed.sql.Database
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.util.*


fun main() {
    embeddedServer(Netty, port = System.getenv()["PORT"]?.toInt() ?: 8080, host = System.getenv()["HOST"] ?: "localhost") {
        configureRouting()
        configureTemplating()
        configureSecurity()
    }.start(wait = true)
}
