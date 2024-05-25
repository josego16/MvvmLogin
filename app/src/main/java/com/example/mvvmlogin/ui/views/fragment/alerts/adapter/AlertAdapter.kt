package com.example.mvvmlogin.ui.views.fragment.alerts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlogin.R
import com.example.mvvmlogin.data.alerts.dao.AlertList

class AlertAdapter : RecyclerView.Adapter<AlertVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerView = R.layout.recyclerview_alert
        return AlertVH(layoutInflater.inflate(recyclerView, parent, false))
    }

    override fun onBindViewHolder(holder: AlertVH, position: Int) {
        holder.renderize(AlertList.alertas[position])
    }

    override fun getItemCount(): Int {
        return AlertList.alertas.size
    }
}