package com.example.dataBase.tables

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val login = varchar("login", 20)
    val password = varchar ("password", 16)
    val fio = varchar("fio", 50)
    val token = varchar("token", 256)
    val email = varchar("e-mail", 50)
}

class User(id: EntityID<Int>): IntEntity(id) {
    companion object: EntityClass<Int, User>(Users)
    var login by Users.login
    var password by Users.password
    var fio by Users.fio
    var token by Users.token
    var email by Users.email
}