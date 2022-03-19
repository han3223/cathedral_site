package com.example.dataBase.registrationUser

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import java.sql.DriverManager

fun Route.checkUser(){
    post("/qwert") {
        val params = call.receiveParameters()
        val loginn = params["name"] ?: return@post call.respond(HttpStatusCode.BadRequest)
        val pas = params["pas"] ?: return@post call.respond(HttpStatusCode.BadRequest)

        val query = "select * from mydbtest.users"

        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            val connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "root")
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(query)
            while (resultSet.next()) {
                if (loginn == resultSet.getString("login")){
                    val fio = resultSet.getString("fio")
                    println(fio)
                }

            }
            println("успешно")
        } catch (e: Exception) {
            e.printStackTrace()
            println("не удалось")
        }
    }
}

fun Application.check(){routing { checkUser() }}