package com.example.mvvmlogin.domain.alerts.usecase

import com.example.mvvmlogin.data.alerts.dao.AlertRepository
import com.example.mvvmlogin.data.alerts.models.Alert
import javax.inject.Inject

class UsecaseAddAlert @Inject constructor() {
    operator fun invoke(alert: Alert): List<Alert> {
        return AlertRepository.dao.addAlert(alert)
    }
}