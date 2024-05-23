package com.example.mvvmlogin.ui.views.fragment.alerts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlogin.R

class AlertAdapter : RecyclerView.Adapter<AlertVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerView = R.layout.recyclerview_alert
        return AlertVH(layoutInflater.inflate(recyclerView, parent, false))
    }

    override fun onBindViewHolder(holder: AlertVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}