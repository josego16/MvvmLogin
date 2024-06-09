package com.example.mvvmlogin.domain.alerts.models

import com.example.mvvmlogin.data.alerts.dao.AlertDao
import com.example.mvvmlogin.data.alerts.objects.RepositoryAlerts

class AlertRepository : AlertDao {
    companion object {
        val dao: AlertDao by lazy {
            AlertRepository()
        }
    }

    override fun getAlertFromDatasource(): List<Alert> {
        AlertList.alertas = RepositoryAlerts.alertList.toMutableList()
        return AlertList.alertas
    }

    override fun getAlert(): List<Alert> {
        return AlertList.alertas
    }

    override fun addAlert(alert: Alert): List<Alert> {
        AlertList.alertas.add(alert)
        return getAlert()
    }

    override fun deleteAlert(pos: Int): List<Alert> {
        AlertList.alertas.removeAt(pos)
        return getAlert()
    }

    override fun updateAlert(pos: Int, alert: Alert): List<Alert> {
        AlertList.alertas[pos] = alert
        return getAlert()
    }
}