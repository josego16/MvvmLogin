package com.example.mvvmlogin.ui.viewmodels.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.domain.users.models.User
import javax.inject.Inject

class UserDetailViewModel @Inject constructor():ViewModel(){
    val userDetailLiveData = MutableLiveData<User?>()
}