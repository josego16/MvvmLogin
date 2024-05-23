package com.example.mvvmlogin.ui.views.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
    lateinit var shared: SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    private var user: User? = null
    private val activityContext = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadShared()
        userViewModel.userLiveData.observe(this) { newUser ->
            user = newUser
        }
        if (isLogged()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            initEvent()
        }
    }

    private fun isLogged(): Boolean {
        return shared.getBoolean("logged", false)
    }

    private fun loadShared() {
        shared = getSharedPreferences("shared_pref_file", Context.MODE_PRIVATE)
    }

    private fun initEvent() {
        binding.btnLogin.setOnClickListener { view ->
            if (getUserName().trim() == "" || getPassword().trim() == "")
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            else {
                val usuario = User(getUserName(), getPassword(), "")
                lifecycleScope.launch {
                    login(usuario)
                    if (user != null) {
                        with(shared.edit()) {
                            putString("username",  user!!.name)
                            putString("email", user!!.email)
                            putBoolean("logged", true)
                            apply()
                        }
                        val intent = Intent(activityContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(activityContext, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        binding.btnRegister.setOnClickListener { view ->
            val dialog = RegisterDialogue { usu ->
                lifecycleScope.launch {
                    findUserByName(usu)
                    if (user != null) {
                        Toast.makeText(activityContext, "Usuario ya registrado", Toast.LENGTH_SHORT).show()
                    } else {
                        register(usu)
                        Toast.makeText(activityContext, "Usuario registrado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            dialog.show(supportFragmentManager, "Agregar")
        }
    }

    private fun getUserName(): String {
        return binding.etUsernameLogin.text.toString()
    }

    private fun getPassword(): String {
        return binding.etPasswordLogin.text.toString()
    }

    private suspend fun findUserByName(user: User) {
        userViewModel.getUserName(user.name)
    }

    private suspend fun login(user: User) {
        userViewModel.login(user.name, user.password)
    }

    private suspend fun register(user: User) {
        userViewModel.register(user)
    }
}