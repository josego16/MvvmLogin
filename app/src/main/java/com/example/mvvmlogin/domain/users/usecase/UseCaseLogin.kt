package com.example.mvvmlogin.domain.users.usecase

import com.example.mvvmlogin.data.users.dao.UserDao
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.toDomain
import javax.inject.Inject

class UseCaseLogin @Inject constructor(private val userDao: UserDao) {
}