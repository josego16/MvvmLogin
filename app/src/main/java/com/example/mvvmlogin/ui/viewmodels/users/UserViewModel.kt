package com.example.mvvmlogin.ui.viewmodels.users

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
    val userLiveData = MutableLiveData<UserModel?>()
    suspend fun login(name: String, password: String) {
        val user = getLoginCase(name, password)
        userLiveData.value = user
    }

    suspend fun getUserByName(name: String) {
        val user = getUserNameUseCase(name)
        userLiveData.value = user
    }

    suspend fun register(userModel: UserModel) {
        getRegisterUseCase(userModel)
    }

    suspend fun userExist(name: String): Boolean {
        val user = getUserNameUseCase(name)
        return user != null
    }
}