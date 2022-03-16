package com.example.dataBase.model

data class UserResponseModel(
    val fio: String,
    val email: String,
    val login: String,
    val password: String,
)

data class UserModel(
    val id: Int,
    val fio: String,
    val email: String,
    val login: String,
    val password: String,
    val token: String,
)
