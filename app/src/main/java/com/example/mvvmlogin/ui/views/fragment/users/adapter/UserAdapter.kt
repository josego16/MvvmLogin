package com.example.mvvmlogin.ui.views.fragment.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlogin.R

class UserAdapter : RecyclerView.Adapter<UserVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerView = R.layout.recyclerview_user
        return UserVH(layoutInflater.inflate(recyclerView, parent, false))
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}