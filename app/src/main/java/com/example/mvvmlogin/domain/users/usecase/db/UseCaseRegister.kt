package com.example.mvvmlogin.domain.users.usecase.db

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.data.users.entities.UserEntity
import com.example.mvvmlogin.domain.users.models.UserModel
import javax.inject.Inject

class UseCaseRegister @Inject constructor(private val userDao: UserDao) {
    suspend operator fun invoke(userModel: UserModel) {
        val userEntity = userDao.register(
            UserEntity(
                name = userModel.name,
                email = userModel.email,
                phone = userModel.phone,
                password = userModel.password
            )
        )
    }
}