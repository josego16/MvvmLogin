package com.example.mvvmlogin.ui.viewmodels.alerts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmlogin.domain.alerts.models.Alert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseDeleteAlert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseEditAlert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseGetAlert
import com.example.mvvmlogin.domain.alerts.usecase.UsecaseAddAlert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlertViewModel @Inject constructor(
    private val alertGetUseCase: UseCaseGetAlert,
    private val alertAddUseCase: UsecaseAddAlert,
    private val alertDeleteUseCase: UseCaseDeleteAlert,
    private val alertEditUsecase: UseCaseEditAlert
) : ViewModel() {
    var alertLiveData = MutableLiveData<List<Alert>>()
    fun listAlerts() {
        viewModelScope.launch {
            val alerts = alertGetUseCase()
            alertLiveData.value = alerts
        }
    }

    fun addAlert(alert: Alert) {
        viewModelScope.launch {
            val alerts = alertAddUseCase(alert)
            alertLiveData.value = alerts
        }
    }

    fun removeAlert(pos: Int) {
        viewModelScope.launch {
            val alerts = alertDeleteUseCase(pos)
            alertLiveData.value = alerts
        }
    }

    fun editAlert(pos: Int, alert: Alert) {
        viewModelScope.launch {
            val alerts = alertEditUsecase(pos, alert)
            alertLiveData.value = alerts
        }
    }
}