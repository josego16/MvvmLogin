package com.example.mvvmlogin.ui.views.fragment.usuario

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.mvvmlogin.data.usuarios.UsuarioList
import com.example.mvvmlogin.databinding.FragmentUserDetailBinding

class UsuarioDetailFragment : Fragment() {
    private lateinit var binding: FragmentUserDetailBinding
    val args: UsuarioDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val usuario = UsuarioList.usuarios[args.num]
        Glide.with(this).load(usuario.imagen).centerCrop().into(binding.imageViewUser)
        binding.imageViewUser.clipToOutline = true
        binding.tvUserName.text = usuario.name
        binding.tvUserEmail.text = usuario.email
        binding.tvUserPhone.text = usuario.phone
        setOnclickListener()
    }

    private fun setOnclickListener() {
        binding.btnPhone.setOnClickListener {
            pedirPermisos()
        }
        binding.btnEmail.setOnClickListener {
            crearCorreo()
        }
    }

    private fun crearCorreo() {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, "${binding.tvUserEmail.text}")
            putExtra(Intent.EXTRA_SUBJECT, "")
        }
        startActivity(intent)
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:${binding.tvUserPhone.text}")
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(context, "Error al iniciar la llamada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun permissionPhone(): Boolean = ContextCompat.checkSelfPermission(
        requireActivity(),
        android.Manifest.permission.CALL_PHONE
    ) == PackageManager.PERMISSION_GRANTED

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            call()
        } else {
            Toast.makeText(context, "Necesitas habilitar los permisos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pedirPermisos() {
        if (permissionPhone()) {
            call()
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.CALL_PHONE)
        }
    }
}