package com.atdev.mvvmkotlin

import com.atdev.mvvmkotlin.pojo.models.User

class SingleTon2 {

    companion object Test {

        fun getInstance(): User {

            return User("Ahmed", "username", "image")
        }
    }
}