package com.example.dataBase.mapper

import com.example.dataBase.model.UserModel
import com.example.dataBase.tables.User


class UserMapper : Mapper<User, UserModel> {
    override fun invoke(input: User): UserModel {
        return UserModel(
            login = input.login,
            password = input.password,
            fio = input.fio,
            token = input.token,
            id = input.id.value,
            email = input.email
        )
    }
}