package com.example.mvvmlogin.ui.viewmodels.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.usecase.db.UseCaseUserName
import com.example.mvvmlogin.domain.users.usecase.network.LoginUseCase
import com.example.mvvmlogin.domain.users.usecase.network.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    /*private val getLoginCase: UseCaseLogin,
    private val getRegisterUseCase: UseCaseRegister,*/
    private val getUserNameUseCase: UseCaseUserName,
    private val loginUseCase: LoginUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    val userLiveData = MutableLiveData<UserModel?>()
    /*suspend fun login(name: String, password: String) {
        val user = getLoginCase(name, password)
        userLiveData.value = user
    }*/

    /*suspend fun register(userModel: UserModel) {
        getRegisterUseCase(userModel)
    }*/

    suspend fun getUserByName(name: String) {
        val user = getUserNameUseCase(name)
        userLiveData.value = user
    }

    suspend fun userExist(name: String): Boolean {
        val user = getUserNameUseCase(name)
        return user != null
    }

    suspend fun login(username: String, password: String) {
        val user = loginUseCase(username, password)
        userLiveData.value = user
    }

    suspend fun register(userModel: UserModel): String {
        return registerUseCase(userModel)
    }
}