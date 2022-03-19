package com.example.dataBase.model

data class AutorizationUser(val fio: String, val email: String, val login: String, val password: String, val token: String)

val emptyUser = mutableListOf(AutorizationUser("", "", "", "", ""))

