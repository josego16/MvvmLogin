package com.example.mvvmlogin.ui.views.fragment.usuario.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmlogin.data.usuarios.entities.Usuario
import com.example.mvvmlogin.databinding.RecyclerviewUserBinding
import com.example.mvvmlogin.ui.views.activities.MainActivity
import com.example.mvvmlogin.ui.views.fragment.usuario.UsuarioFragmentDirections

class UsuarioVH(view: View) : RecyclerView.ViewHolder(view) {
    var binding: RecyclerviewUserBinding = RecyclerviewUserBinding.bind(view)
    private var mainActivity: MainActivity = view.context as MainActivity

    fun renderize(usuario: Usuario) {
        binding.tvUserName.text = usuario.name
        binding.tvUserEmail.text = usuario.email
        binding.tvUserPhone.text = usuario.phone
        Glide.with(itemView.context).load(usuario.imagen).centerCrop().into(binding.ivUser)
        setOnClickListener(bindingAdapterPosition, usuario)
    }

    private fun setOnClickListener(position: Int, usuario: Usuario) {
        binding.btnDetails.setOnClickListener { view ->
            mainActivity.navController.navigate(UsuarioFragmentDirections.actionUserFragmentToUserDetailFragment(position))
        }
    }
}