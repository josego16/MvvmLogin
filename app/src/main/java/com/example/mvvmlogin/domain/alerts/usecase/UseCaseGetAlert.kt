package com.example.mvvmlogin.domain.alerts.usecase

import com.example.mvvmlogin.domain.alerts.models.AlertRepository
import com.example.mvvmlogin.domain.alerts.models.Alert
import javax.inject.Inject

class UseCaseGetAlert @Inject constructor() {
    operator fun invoke ():List<Alert> {
        return AlertRepository.dao.getAlert()
    }
}