package com.example.mvvmlogin.domain.alerts.usecase

import com.example.mvvmlogin.domain.alerts.models.AlertRepository
import com.example.mvvmlogin.domain.alerts.models.Alert
import javax.inject.Inject

class UseCaseEditAlert @Inject constructor() {
    operator fun invoke(pos: Int,alert: Alert):List<Alert>{
        return AlertRepository.dao.updateAlert(pos,alert)
    }
}