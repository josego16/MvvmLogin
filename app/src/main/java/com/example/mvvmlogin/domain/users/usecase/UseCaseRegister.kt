package com.example.mvvmlogin.domain.users.usecase

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.data.users.entities.UserEntity
import com.example.mvvmlogin.domain.users.models.User
import javax.inject.Inject

class UseCaseRegister @Inject constructor(private val userDao: UserDao) {
    suspend operator fun invoke(user: User) {
        val userEntity = userDao.register(
            UserEntity(
                name = user.name,
                email = user.email,
                password = user.password
            )
        )
    }
}