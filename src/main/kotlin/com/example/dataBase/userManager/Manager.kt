package com.example.dataBase.userManager

import com.example.dataBase.mapper.UserMapper
import com.example.dataBase.model.UserModel
import com.example.dataBase.model.UserResponseModel
import com.example.dataBase.tables.User
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserManager(
    private val userMapper: UserMapper
) {
    fun checkAuth(userModel: UserModel) = kotlin.runCatching {
        transaction {

        }
    }

    fun getUsers() = runCatching {
        transaction {
            User.all().map { user -> userMapper(user) }
        }
    }.getOrElse { it.localizedMessage }

    fun addUser(userModel: UserResponseModel) = runCatching {
        transaction {
            User.new {
                login = userModel.login
                password = userModel.password
                fio = userModel.fio
                email = userModel.email
                token = (userModel.fio.hashCode() % 100000000).toString()
            }.let {
                userMapper(it)
            }
        }
    }.getOrElse { it.localizedMessage }

    fun deleteUser () = runCatching {  }
}

fun Route.userRouting() {
    get("/h") { call.respondText("eeeee") }
    post() {  }
    post() {  }
}

fun Application.reristrationBlock(){
    routing { userRouting() }
}

val userNoRegistration = UserResponseModel("", "", "", "")
val userRegistration = UserModel (1, "Важенин Иван Анатольевич", "ivan.vazhenin34@gmail.com", "ivan34", "qwerty123", token = "1234567890")