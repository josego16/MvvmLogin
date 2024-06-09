package com.example.mvvmlogin.domain.alerts.models

data class Alert(
    /*val id: Int = 0,
    val userId: Int,*/
    val nameAlert: String,
    val description: String,
    val alertDate: String
) {
    override fun toString(): String {
        return String.format("Nombre de la alerta: %s\nDescripcion: %s\nFecha: %s", nameAlert, description, alertDate)
    }
}