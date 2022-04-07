package com.onirutla.storyapp.data.source.repository.user

import android.util.Log
import com.onirutla.storyapp.data.model.BaseResponse
import com.onirutla.storyapp.data.model.user.body.UserLoginBody
import com.onirutla.storyapp.data.model.user.body.UserRegisterBody
import com.onirutla.storyapp.data.model.user.response.LoginResponse
import com.onirutla.storyapp.data.source.api_service.UserApiService

class UserRepositoryImpl(
    private val userApiService: UserApiService
) : UserRepository {

    override suspend fun registerUser(registerBody: UserRegisterBody): BaseResponse =
        try {
            val response = userApiService.registerUser(registerBody)
            if (response.isSuccessful) {
                Log.d("userRepository", "${response.body()}")
                response.body()!!
            } else {
                Log.d("userRepository", "${response.errorBody()}")
                BaseResponse()
            }
        } catch (e: Exception) {
            Log.d("userRepository", "$e", e)
            BaseResponse()
        }

    override suspend fun loginUser(loginBody: UserLoginBody): LoginResponse = try {
        val response = userApiService.loginUser(loginBody)
        if (response.isSuccessful) {
            Log.d("userRepository", "${response.body()}")
            response.body()!!
        } else {
            Log.d("userRepository", "${response.errorBody()}")
            LoginResponse()
        }
    } catch (e: Exception) {
        Log.d("userRepository", "$e", e)
        LoginResponse()
    }
}