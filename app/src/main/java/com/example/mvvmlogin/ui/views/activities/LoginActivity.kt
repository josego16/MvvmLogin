package com.example.mvvmlogin.ui.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mvvmlogin.databinding.ActivityLoginBinding
import com.example.mvvmlogin.domain.users.models.User
import com.example.mvvmlogin.ui.viewmodels.users.UserViewModel
import com.example.mvvmlogin.ui.views.dialogues.RegisterDialogue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBtn()
        initEvent()
    }

    private fun initEvent() {
        binding.btnLogin.setOnClickListener { view ->
            lifecycleScope.launch {
                userViewModel.login(
                    binding.etUsernameLogin.text.toString(),
                    binding.etPasswordLogin.text.toString()
                )
            }
        }
        binding.btnRegister.setOnClickListener { view ->
            val dialog = RegisterDialogue { user ->
                okOnRegisterUser(user)
            }
            dialog.show(supportFragmentManager, "Usuario agregado")
        }
    }
    private fun okOnRegisterUser(user: User) {
        lifecycleScope.launch {
            userViewModel.register(user)
        }
    }

    private fun initBtn() {
        TODO("Not yet implemented")
    }
}