package com.example.mvvmlogin.ui.viewmodels.users

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.usecase.UseCaseLogin
import com.example.mvvmlogin.domain.users.usecase.UseCaseRegister
import com.example.mvvmlogin.domain.users.usecase.UseCaseUserName
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getLoginCase: UseCaseLogin,
    private val getRegisterUseCase: UseCaseRegister,
    private val getUserNameUseCase: UseCaseUserName
) : ViewModel() {
}