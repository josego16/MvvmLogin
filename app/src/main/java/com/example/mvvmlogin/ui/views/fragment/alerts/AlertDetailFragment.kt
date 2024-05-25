package com.example.mvvmlogin.ui.views.fragment.alerts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mvvmlogin.data.alerts.dao.AlertList
import com.example.mvvmlogin.databinding.FragmentAlertDetailBinding

class AlertDetailFragment : Fragment() {
    private lateinit var binding: FragmentAlertDetailBinding
    val arg: AlertDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAlertDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val alerta = AlertList.alertas[arg.num]
        binding.tvAlertRecyclerNombre.text = alerta.nameAlert
        binding.tvAlertRecyclerDescription.text = alerta.description
        binding.tvAlertRecyclerFecha.text = alerta.alertDate
    }
}