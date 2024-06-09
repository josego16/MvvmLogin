package com.example.mvvmlogin.ui.views.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mvvmlogin.R
import com.example.mvvmlogin.domain.alerts.models.Alert
import com.example.mvvmlogin.data.alerts.objects.ArgumentAlert
import com.example.mvvmlogin.databinding.FragmentDialogAlertBinding
import com.example.mvvmlogin.domain.alerts.datepicker.DatePicker
import com.example.mvvmlogin.ui.views.activities.MainActivity

class EditDialogue(
    val pos: Int,
    val alert: Alert,
    val okOnEditAlert: (Alert, Int) -> Unit
) : DialogFragment() {
    init {
        val args = Bundle().apply {
            putString(ArgumentAlert.NAME_FIELDS, alert.nameAlert)
            putString(ArgumentAlert.DESCRIPTION_FIELDS, alert.description)
            putString(ArgumentAlert.ALERTDATE_FIELDS, alert.alertDate)
        }
        this.arguments = args
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { activity ->
            val builder = AlertDialog.Builder(activity)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_dialog_alert, null)
            builder.setView(view)
            setFields(view)
            builder.setMessage("Editar alerta")
            builder.setPositiveButton("Editar") { dialog, id ->
                val alert = createAlert(view)
                if (isAlertFilled(alert)) {
                    okOnEditAlert(alert, pos)
                    (activity as MainActivity).adapter.editAlert(pos, alert)
                } else {
                    Toast.makeText(
                        activity,
                        "Todos los campos son obligatorios",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, id ->
                Toast.makeText(activity, "Operacion cancelada", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun setFields(view: View) {
        val binding = FragmentDialogAlertBinding.bind(view)
        arguments?.let { args ->
            binding.etAlertRecyclerName.setText(args.getString(ArgumentAlert.NAME_FIELDS))
            binding.etAlertRecyclerDate.setText(args.getString(ArgumentAlert.ALERTDATE_FIELDS))
            binding.etAlertRecyclerDescripcion.setText(args.getString(ArgumentAlert.DESCRIPTION_FIELDS))
        }

        binding.etAlertRecyclerDate.setOnClickListener {
            val datePicker = DatePicker { day, month, year ->
                val date = "$day/${month + 1}/$year"
                binding.etAlertRecyclerDate.setText(date)
            }
            datePicker.show(childFragmentManager, "DatePicker")
        }
    }

    private fun createAlert(view: View): Alert {
        val binding = FragmentDialogAlertBinding.bind(view)
        return Alert(
            binding.etAlertRecyclerName.text.toString(),
            binding.etAlertRecyclerDescripcion.text.toString(),
            binding.etAlertRecyclerDate.text.toString()
        )
    }

    private fun isAlertFilled(alert: Alert): Boolean {
        return (!(alert.nameAlert.isNullOrBlank() || alert.alertDate.isNullOrBlank()))
    }
}