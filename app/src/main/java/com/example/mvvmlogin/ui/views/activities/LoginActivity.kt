package com.example.mvvmlogin.ui.views.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mvvmlogin.databinding.ActivityLoginBinding
import com.example.mvvmlogin.domain.users.models.UserModel
import com.example.mvvmlogin.ui.viewmodels.users.UserViewModel
import com.example.mvvmlogin.ui.views.dialogues.RegisterDialogue
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val userViewModel: UserViewModel by viewModels()
    private var userModel: UserModel? = null
    lateinit var shared: SharedPreferences
    private val activityContext = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadSharedPreferences()
        userViewModel.userLiveData.observe(this) { newUser ->
            userModel = newUser
        }
        if (isLoggedIn()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            initBtn()
        }
    }

    private fun isLoggedIn(): Boolean {
        return shared.getBoolean("isLoggedIn", false)
    }

    private fun loadSharedPreferences() {
        shared = getSharedPreferences("shared_pref_file", Context.MODE_PRIVATE)
    }

    private fun saveSharedPreferences(userModel: UserModel) {
        with(shared.edit()) {
            putString("email", userModel.email)
            putString("password", userModel.password)
            putBoolean("isLoggedIn", true)
            apply()
        }
    }

    private fun initBtn() {
        binding.btnLogin.setOnClickListener { vista ->
            if (getEmail().trim() == "" || getPass().trim() == "") {
                Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show()
            } else {
                val fielduser = UserModel("", getEmail(), "", getPass(), "", "")
                lifecycleScope.launch {
                    login(fielduser)
                }
            }
        }
        binding.btnRegister.setOnClickListener { vista ->
            val dialog = RegisterDialogue { fieluser ->
                lifecycleScope.launch {
                    findUserByEmail(fieluser)
                    if (userModel != null) {
                        Toast.makeText(activityContext, "Usuario ya registrado", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        register(fieluser)
                        Toast.makeText(activityContext, "Usuario registrado", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            dialog.show(supportFragmentManager, "Registro")
        }
    }

    private fun getEmail(): String {
        return binding.etEmailLogin.text.toString().trim()
    }

    private fun getPass(): String {
        return binding.etPasswordLogin.text.toString().trim()
    }

    private suspend fun findUserByEmail(user: UserModel) { // Para el registro
        userViewModel.getUserByEmail(user.email)
    }

    private suspend fun login(user: UserModel) {
        val result = userViewModel.login(user.email, user.password)
        if (result != null) {
            val userExist = userViewModel.userExist(user.email)
            if (userExist) {
                saveSharedPreferences(user)
                val intent = Intent(activityContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    activityContext, "Usuario no registrado", Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(
                activityContext, "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT
            ).show()
        }
    }

    private suspend fun register(user: UserModel) {
        userViewModel.register(user)
    }
}