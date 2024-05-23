package com.example.mvvmlogin.ui.views.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.mvvmlogin.R
import com.example.mvvmlogin.databinding.ActivityMainBinding
import com.example.mvvmlogin.ui.viewmodels.alerts.AlertViewModel
import com.example.mvvmlogin.ui.viewmodels.users.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    val alertViewmodel: AlertViewModel by viewModels()
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        initList()
        initNavElements()
        initBottombar()
    }

    private fun initBottombar() {
        TODO("Not yet implemented")
    }

    private fun initNavElements() {
        TODO("Not yet implemented")
    }

    private fun initList() {
        TODO("Not yet implemented")
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_home -> {
                navController.navigate(R.id.homeFragment)
                true
            }

            R.id.toolbar_logout -> {
                navController.navigate(R.id.toolbar_logout)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}