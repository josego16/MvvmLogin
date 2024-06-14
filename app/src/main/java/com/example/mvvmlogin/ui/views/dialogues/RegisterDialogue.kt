package com.example.mvvmlogin.ui.views.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.mvvmlogin.R
import com.example.mvvmlogin.databinding.FragmentDialogRegisterBinding
import com.example.mvvmlogin.domain.users.models.UserModel

class RegisterDialogue(var okOnCreateUser: (UserModel) -> Unit) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { activity ->
            val builder = AlertDialog.Builder(activity)
            val inflater = activity.layoutInflater
            val viewUser = inflater.inflate(R.layout.fragment_dialog_register, null)

            builder.setView(viewUser)
            builder.setMessage("Crear usuario")
            builder.setPositiveButton("Crear") { dialog, id ->
                val user = createNewUser(viewUser)
                if (isUserFilled(user)) {
                    if (isUserValid(user)) {
                        okOnCreateUser(user)
                    } else {
                        Toast.makeText(activity, "Formato incorrecto", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(
                        activity,
                        "Todos los campos son obligatorios",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, id ->
                Toast.makeText(activity, "Operacion cancelada", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun createNewUser(view: View): UserModel {
        val binding = FragmentDialogRegisterBinding.bind(view)
        return UserModel(
            binding.etUsernameRegister.text.toString(),
            binding.etEmailRegister.text.toString(),
            binding.etPhoneRegister.text.toString(),
            binding.etPasswordRegister.text.toString()
        )
    }

    private fun isUserFilled(userModel: UserModel): Boolean {
        return (!(userModel.name.isEmpty() || userModel.email.isEmpty() || userModel.password.isEmpty()))
    }

    private fun isUserValid(userModel: UserModel): Boolean {
        return true
    }
}