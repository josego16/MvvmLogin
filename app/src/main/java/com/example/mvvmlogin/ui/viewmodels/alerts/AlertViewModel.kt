package com.example.mvvmlogin.ui.viewmodels.alerts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmlogin.data.alerts.models.Alert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseDeleteAlert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseEditAlert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseGetAlert
import com.example.mvvmlogin.domain.alerts.usecase.UsecaseAddAlert
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlertViewModel @Inject constructor(
    private val alertAddUseCase: UsecaseAddAlert,
    private val alertDeleteUseCase: UseCaseDeleteAlert,
    private val alertEditUsecase: UseCaseEditAlert,
    private val alertGetUseCase: UseCaseGetAlert
) : ViewModel() {
}