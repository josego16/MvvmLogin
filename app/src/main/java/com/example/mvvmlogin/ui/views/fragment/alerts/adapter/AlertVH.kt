package com.example.mvvmlogin.ui.views.fragment.alerts.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlogin.domain.alerts.models.AlertList
import com.example.mvvmlogin.domain.alerts.models.Alert
import com.example.mvvmlogin.databinding.RecyclerviewAlertBinding
import com.example.mvvmlogin.ui.views.activities.MainActivity
import com.example.mvvmlogin.ui.views.dialogues.DeleteDialogue
import com.example.mvvmlogin.ui.views.dialogues.EditDialogue
import com.example.mvvmlogin.ui.views.fragment.alerts.AlertFragmentDirections

class AlertVH(view: View) : RecyclerView.ViewHolder(view) {
    private var binding: RecyclerviewAlertBinding = RecyclerviewAlertBinding.bind(view)
    private var mainActivity: MainActivity = view.context as MainActivity
    fun renderize(alert: Alert) {
        binding.tvAlertRecyclerNombre.text = alert.nameAlert
        binding.tvAlertRecyclerDescription.text = alert.description
        binding.tvAlertRecyclerFecha.text = alert.alertDate
        setOnClickListener(bindingAdapterPosition, alert)
    }

    private fun setOnClickListener(pos: Int, alert: Alert) {
        binding.btnDelete.setOnClickListener { view ->
            delAlert(pos)
        }
        binding.btnEdit.setOnClickListener { view ->
            editAlert(pos, alert)
        }
        binding.btnDetails.setOnClickListener { view ->
            mainActivity.navController.navigate(
                AlertFragmentDirections.actionAlertFragmentToAlertDetailFragment(pos)
            )
        }
    }

    private fun delAlert(pos: Int) {
        val dialog = DeleteDialogue(pos, AlertList.alertas[pos].alertDate) { position ->
            mainActivity.alertViewmodel.removeAlert(pos)
        }
        dialog.show(mainActivity.supportFragmentManager, "Eliminar")
    }

    private fun editAlert(pos: Int, alert: Alert) {
        val dialog = EditDialogue(pos, alert) { posi, alerta ->
            mainActivity.alertViewmodel.editAlert(pos, alert)
        }
        dialog.show(mainActivity.supportFragmentManager, "Editar")
    }
}