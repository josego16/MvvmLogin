package com.example.mvvmlogin.ui.views.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mvvmlogin.R
import com.example.mvvmlogin.domain.alerts.models.Alert
import com.example.mvvmlogin.databinding.FragmentDialogAlertBinding
import com.example.mvvmlogin.domain.alerts.datepicker.DatePicker

class AddDialogue(var okOnCreateAlert: (Alert) -> Unit) : DialogFragment() {
    private lateinit var datePicker: DatePicker
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(requireContext())
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_dialog_alert, null)
            builder.setView(view)

            val binding = FragmentDialogAlertBinding.bind(view)
            binding.etAlertRecyclerDate.setOnClickListener {
                datePicker = DatePicker { day, month, year ->
                    val date = "$day/${month + 1}/$year"
                    binding.etAlertRecyclerDate.setText(date)
                }
                datePicker.show(childFragmentManager, "DatePicker")
            }
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