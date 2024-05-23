package com.example.mvvmlogin.domain.users.usecase

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.domain.users.models.User
import com.example.mvvmlogin.domain.users.toDomain
import javax.inject.Inject

class UseCaseShowUser @Inject constructor(private val userDao: UserDao) {
    suspend operator fun invoke(name: String): User? {
        val user = userDao.getUserByUsername(name)
        user?.let {
            return user.toDomain()
        }
        return null
    }
}