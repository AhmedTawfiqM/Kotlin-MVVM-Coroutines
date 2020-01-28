package com.atdev.mvvmkotlin.pojo.apis

import com.atdev.mvvmkotlin.pojo.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface APiService {

    @GET("placeholder/user/{userId}")
    suspend fun getUSer(
        @Path("userId")
        userId: String
    ): User
}