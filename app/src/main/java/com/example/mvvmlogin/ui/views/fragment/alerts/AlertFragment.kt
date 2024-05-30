package com.example.mvvmlogin.ui.views.fragment.alerts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmlogin.data.alerts.dao.AlertList
import com.example.mvvmlogin.data.alerts.dao.DatepickerFragment
import com.example.mvvmlogin.databinding.FragmentAlertBinding
import com.example.mvvmlogin.databinding.FragmentDialogAlertBinding
import com.example.mvvmlogin.ui.viewmodels.alerts.AlertViewModel
import com.example.mvvmlogin.ui.views.activities.MainActivity
import com.example.mvvmlogin.ui.views.dialogues.AddDialogue
import com.example.mvvmlogin.ui.views.fragment.alerts.adapter.AlertAdapter

class AlertFragment : Fragment() {
    lateinit var binding: FragmentAlertBinding
    private lateinit var mainActivity: MainActivity
    lateinit var alertViewModel: AlertViewModel
    val adapter: AlertAdapter = AlertAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mainActivity = requireActivity() as MainActivity
        binding = FragmentAlertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.alertRecyclerView.layoutManager = layoutManager
        binding.alertRecyclerView.adapter = adapter

        mainActivity.alertViewmodel.alertLiveData.observe(requireActivity()) {
            binding.alertRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        binding.alertBtnAdd.setOnClickListener {
            addAlert()
        }
    }

    private fun addAlert() {
        val dialog = AddDialogue { alerts ->
            mainActivity.alertViewmodel.addAlert(alerts)
            binding.alertRecyclerView.layoutManager!!.scrollToPosition(AlertList.alertas.lastIndex)
        }
        dialog.show(requireActivity().supportFragmentManager, "Añadir")
    }
}