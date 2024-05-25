package com.example.mvvmlogin.data.alerts.dao

import com.example.mvvmlogin.data.alerts.models.Alert

interface AlertDao {
    fun getAlertFromDatasource(): List<Alert>
    fun getAlert(): List<Alert>
    fun addAlert(alert: Alert): List<Alert>
    fun deleteAlert(pos: Int): List<Alert>
    fun updateAlert(pos: Int, alert: Alert): List<Alert>
}