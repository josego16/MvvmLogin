package com.example.mvvmlogin.ui.views.fragment.usuario

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmlogin.databinding.FragmentUserBinding
import com.example.mvvmlogin.ui.views.activities.MainActivity
import com.example.mvvmlogin.ui.views.fragment.usuario.adapter.UsuarioAdapter

class UsuarioFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }
}