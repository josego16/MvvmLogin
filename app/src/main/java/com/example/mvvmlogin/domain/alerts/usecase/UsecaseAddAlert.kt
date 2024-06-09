package com.example.mvvmlogin.domain.alerts.usecase

import com.example.mvvmlogin.domain.alerts.models.AlertRepository
import com.example.mvvmlogin.domain.alerts.models.Alert
import javax.inject.Inject

class UsecaseAddAlert @Inject constructor() {
    operator fun invoke(alert: Alert): List<Alert> {
        return AlertRepository.dao.addAlert(alert)
    }
}