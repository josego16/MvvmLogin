package com.example.mvvmlogin.ui.views.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mvvmlogin.R
import com.example.mvvmlogin.data.alerts.models.Alert
import com.example.mvvmlogin.databinding.FragmentDialogAlertBinding

class AddDialogue(var okOnCreateAlert: (Alert) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_dialog_alert, null)
            builder.setView(view)
            builder.setMessage("Añadir alerta")
            builder.setPositiveButton("Añadir") { dialog, id ->
                val alert = createAlert(view)
                if (isAlertFilled(alert)) {
                    okOnCreateAlert(alert)
                } else {
                    Toast.makeText(activity, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, id ->
                Toast.makeText(activity, "Operacion cancelada", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun createAlert(view: View): Alert {
        val binding = FragmentDialogAlertBinding.bind(view)
        return Alert(
            binding.etAlertRecyclerName.text.toString(),
            binding.etAlertRecyclerDescripcion.text.toString(),
            binding.etAlertRecyclerDate.text.toString(),
        )
    }

    private fun isAlertFilled(alert: Alert): Boolean {
        return (!(alert.nameAlert.isEmpty() || alert.alertDate.isEmpty()))
    }
}