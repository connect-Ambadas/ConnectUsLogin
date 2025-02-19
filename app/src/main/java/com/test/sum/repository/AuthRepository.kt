package com.test.sum.repository

import com.test.sum.data.model.User
import com.test.sum.data.model.registration.Admin
import com.test.sum.data.network.RetrofitClient
import retrofit2.Response

class AuthRepository {
    suspend fun login(email: String, password: String): Response<User> {
        return RetrofitClient.apiService.login(mapOf("adminEmailId" to email, "adminPassword" to password))
    }
    suspend fun register(admin: Admin): Response<User> {
        return RetrofitClient.apiService.register(
            admin
        )
    }
}