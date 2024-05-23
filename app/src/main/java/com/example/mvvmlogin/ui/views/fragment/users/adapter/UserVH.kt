package com.example.mvvmlogin.ui.views.fragment.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmlogin.databinding.RecyclerviewUserBinding
import com.example.mvvmlogin.domain.users.models.Usuario
import com.example.mvvmlogin.ui.views.activities.MainActivity

class UserVH(view: View): RecyclerView.ViewHolder(view) {
    var binding : RecyclerviewUserBinding = RecyclerviewUserBinding.bind(view)
    private var mainActivity: MainActivity = view.context as MainActivity

    fun renderize(usuario: Usuario){
        binding.tvUserName.text = usuario.name
        binding.tvUserEmail.text = usuario.email
        binding.tvUserPhone.text = usuario.phone
        Glide.with(itemView.context).load(usuario.imagen).centerCrop().into(binding.ivUser)
        setOnClickListener(adapterPosition, usuario)
    }

    private fun setOnClickListener(position: Int, usuario: Usuario) {
        binding.btnDetails.setOnClickListener { view ->
        }
    }
}