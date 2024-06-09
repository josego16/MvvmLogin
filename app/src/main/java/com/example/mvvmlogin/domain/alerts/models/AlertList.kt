package com.example.mvvmlogin.domain.alerts.models

class AlertList {
    companion object {
        var alertas: MutableList<Alert> = emptyList<Alert>().toMutableList()
    }
}