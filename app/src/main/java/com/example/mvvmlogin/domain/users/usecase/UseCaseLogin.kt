package com.example.mvvmlogin.domain.users.usecase

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.domain.users.models.User
import com.example.mvvmlogin.domain.users.toDomain
import javax.inject.Inject

class UseCaseLogin @Inject constructor(private val userDao: UserDao){
    suspend operator fun invoke(email: String, password: String) : User?{
        val user = userDao.login(email,password)
        user?.let {
            return user.toDomain()
        }
        return null
    }
}