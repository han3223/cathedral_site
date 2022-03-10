package com.example

import io.ktor.application.*
import com.example.plugins.*
import com.typesafe.config.ConfigFactory
import io.ktor.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, environment = applicationEngineEnvironment {
        config = HoconApplicationConfig(ConfigFactory.load())

        module {
            configureRouting()
            configureSecurity()
            configureHTTP()
            configureTemplating()
            configureSerialization()
            configureSockets()
            configureAdministration()
            configureMonitoring()

        }

        connector {
            port = config.property("ktor.deployment.port").getString().toInt()
            host = config.property("ktor.deployment.host").getString()
        }
    }).start(wait = true)
}
