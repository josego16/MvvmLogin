package com.example.mvvmlogin.data.alerts

import com.example.mvvmlogin.data.alerts.models.Alert

class AlertList {
    companion object {
        var alertas: MutableList<Alert> = emptyList<Alert>().toMutableList()
    }
}