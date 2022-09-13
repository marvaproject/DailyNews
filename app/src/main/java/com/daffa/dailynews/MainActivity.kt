package com.daffa.dailynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.*
import com.daffa.dailynews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _appBarConfig: AppBarConfiguration? = null
    private val appBarConfig get() = _appBarConfig as AppBarConfiguration

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    lateinit var drawerLayout: DrawerLayout
    lateinit var toogle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        drawerLayout = binding.activityMain
        _appBarConfig = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.newsFragment, R.id.esportFragment, R.id.talkFragment, R.id.reviewFragment
            ), drawerLayout
        )

        val navView = binding.navDrawerMain
        val navController = findNavController(R.id.host_main)

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)

        drawerLayout.openDrawer(Gravity.LEFT)
        drawerLayout.closeDrawer(Gravity.LEFT)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.host_main)
        return super.onSupportNavigateUp() || navController.navigateUp(appBarConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.host_main)
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }
}