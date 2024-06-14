package com.example.mvvmlogin.domain.users.usecase.db

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.toDomain
import javax.inject.Inject

class UseCaseFindEmail @Inject constructor(private val userDao: UserDao) {
    suspend operator fun invoke(email: String): UserModel? {
        val user = userDao.getUserByEmail(email)
        user?.let {
            return user.toDomain()
        }
        return null
    }
}