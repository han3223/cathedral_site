package com.example.dataBase.mapper

interface Mapper<Input, Output> {
    operator fun invoke(input: Input): Output
}