package com.example.mvvmlogin.ui.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmlogin.R
import com.example.mvvmlogin.data.alerts.dao.AlertList
import com.example.mvvmlogin.data.alerts.objects.RepositoryAlerts
import com.example.mvvmlogin.data.usuarios.UsuarioList
import com.example.mvvmlogin.data.usuarios.objects.RepositoryUsers
import com.example.mvvmlogin.databinding.ActivityMainBinding
import com.example.mvvmlogin.ui.viewmodels.alerts.AlertViewModel
import com.example.mvvmlogin.ui.viewmodels.users.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    lateinit var appBarConfiguration: AppBarConfiguration

    val alertViewmodel: AlertViewModel by viewModels()
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        initList()
        initNavElements()
        initBottomBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this, "Navegacion pulsada", Toast.LENGTH_SHORT).show()
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun initBottomBar() {
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.alertFragment,
                R.id.profileFragment,
                R.id.userFragment
            ), binding.drawerlayout
        )
        binding.appBarMain.appBtnBar.appBtnNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun initList() {
        AlertList.alertas = RepositoryAlerts.alertList.toMutableList()
        UsuarioList.usuarios = RepositoryUsers.usuarioList.toMutableList()
    }

    private fun initNavElements() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
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
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}