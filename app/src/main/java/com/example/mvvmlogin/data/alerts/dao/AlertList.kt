package com.example.mvvmlogin.data.alerts.dao

import com.example.mvvmlogin.data.alerts.models.Alert

class AlertList {
    companion object {
        var alertas: MutableList<Alert> = emptyList<Alert>().toMutableList()
    }
}