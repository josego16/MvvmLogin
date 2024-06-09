package com.example.mvvmlogin.data.alerts.objects

import com.example.mvvmlogin.domain.alerts.models.Alert

object RepositoryAlerts {
    val alertList: List<Alert> = listOf(
        Alert(
            "alerta examen",
            "hay un examen de recuperacion de la asignatura desarrollo de interfaces sobre javascript",
            "29/05/2023"
        ),
        Alert("", "", ""),
        Alert("", "", ""),
        Alert("", "", ""),
        Alert("", "", ""),
    )
}