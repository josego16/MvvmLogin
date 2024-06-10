package com.example.mvvmlogin.domain.users.usecase.db

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.toDomain
import javax.inject.Inject

class UseCaseLogin @Inject constructor(private val userDao: UserDao) {
    suspend operator fun invoke(name: String, password: String): UserModel? {
        val user = userDao.login(name, password)
        user?.let {
            return user.toDomain()
        }
        return null
    }
}