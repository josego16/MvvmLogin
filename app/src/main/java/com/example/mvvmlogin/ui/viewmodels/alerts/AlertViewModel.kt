package com.example.mvvmlogin.ui.viewmodels.alerts

import androidx.lifecycle.ViewModel
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseDeleteAlert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseEditAlert
import com.example.mvvmlogin.domain.alerts.usecase.UseCaseGetAlert
import com.example.mvvmlogin.domain.alerts.usecase.UsecaseAddAlert
import javax.inject.Inject

class AlertViewModel @Inject constructor(
    alertAddUseCase: UsecaseAddAlert,
    alertDeleteUseCase: UseCaseDeleteAlert,
    alertEditUsecase: UseCaseEditAlert,
    alertGetUseCase: UseCaseGetAlert
) : ViewModel(){
}