package com.example.mvvmlogin.ui.views.fragment.usuario.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlogin.R
import com.example.mvvmlogin.domain.usuarios.models.UsuarioList

class UsuarioAdapter : RecyclerView.Adapter<UsuarioVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerView = R.layout.recyclerview_user
        return UsuarioVH(layoutInflater.inflate(recyclerView, parent, false))
    }

    override fun onBindViewHolder(holder: UsuarioVH, position: Int) {
        holder.renderize(UsuarioList.usuarios[position])
    }

    override fun getItemCount(): Int {
        return UsuarioList.usuarios.size
    }
}