package com.example.mvvmlogin.domain.alerts.usecase

import com.example.mvvmlogin.domain.alerts.models.AlertRepository
import com.example.mvvmlogin.domain.alerts.models.Alert
import javax.inject.Inject

class UseCaseDeleteAlert @Inject constructor() {
    operator fun invoke(pos: Int): List<Alert> {
        return AlertRepository.dao.deleteAlert(pos)
    }
}