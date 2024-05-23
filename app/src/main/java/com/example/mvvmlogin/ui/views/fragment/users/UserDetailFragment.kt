package com.example.mvvmlogin.ui.views.fragment.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mvvmlogin.data.users.UserList
import com.example.mvvmlogin.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailBinding
    val args: UserDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val usuario = UserList.usuarios[args.num]
        Glide.with(this).load(usuario.imagen).centerCrop().into(binding.imageViewUser)
        binding.imageViewUser.clipToOutline = true
        binding.tvUserName.text = usuario.name
        binding.tvUserEmail.text = usuario.email
        binding.tvUserPhone.text = usuario.phone
    }
}