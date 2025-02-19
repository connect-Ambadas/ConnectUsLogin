package com.test.sum.data.network

import com.test.sum.data.model.User
import com.test.sum.data.model.registration.Admin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/loginChecker")
    suspend fun login(@Body request: Map<String, String>): Response<User>
    @POST("/createAdmin")
    suspend fun register(@Body request: Admin): Response<User>
}