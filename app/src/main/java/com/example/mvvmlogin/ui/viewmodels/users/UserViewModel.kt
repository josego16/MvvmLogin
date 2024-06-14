package com.example.mvvmlogin.ui.viewmodels.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.domain.users.models.UserRepository
import com.example.mvvmlogin.domain.users.usecase.db.UseCaseFindEmail
import com.example.mvvmlogin.domain.users.usecase.network.LoginUseCase
import com.example.mvvmlogin.domain.users.usecase.network.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getEmailUseCase: UseCaseFindEmail
) : ViewModel() {
    private val repository = UserRepository.repository
    private val loginUseCase = LoginUseCase(repository)
    private val registerUseCase = RegisterUseCase(repository)

    val userLiveData = MutableLiveData<UserModel?>()
    val registerLiveData = MutableLiveData<Boolean>()


    suspend fun getUserByEmail(email: String) {
        val user = getEmailUseCase(email)
        userLiveData.value = user
    }

    suspend fun userExist(email: String): Boolean {
        val user = getEmailUseCase(email)
        return user != null
    }

    suspend fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user: UserModel? = null
            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = loginUseCase.login(email, password)
            }
            withContext(Dispatchers.Main) {
                if (user != null) {
                    userLiveData.value = user
                } else {
                    userLiveData.value = null
                }
            }
        }
    }

    suspend fun register(user: UserModel) {
        var reg: Boolean

        viewModelScope.launch(Dispatchers.IO) {
            reg = registerUseCase.register(user)  //registramos el usuario
            withContext(Dispatchers.Main) {
                registerLiveData.value = reg
            }
        }
    }
}