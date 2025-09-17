package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.listFragment, R.id.favoritesFragment, R.id.cafeFragment),
            findViewById(R.id.drawer_layout)
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        // Drawer navigation
        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)

        // Bottom navigation (pastikan ada BottomNavigationView dengan id bottom_nav di layout)
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            ?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        // pakai NavigationUI.navigateUp supaya compatible dengan berbagai versi library
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
