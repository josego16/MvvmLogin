package com.example.mvvmlogin.domain.users.usecase.db

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.toDomain
import javax.inject.Inject

class UseCaseUserName @Inject constructor(private val userDao: UserDao) {
    suspend operator fun invoke(name: String): UserModel? {
        val user = userDao.getUserByUsername(name)
        user?.let {
            return user.toDomain()
        }
        return null
    }
}