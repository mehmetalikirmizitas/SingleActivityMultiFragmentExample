package com.example.bottom_navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottom_navigation.databinding.ActivityMainBinding
import com.example.bottom_navigation.util.gone
import com.example.bottom_navigation.util.visible
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView


        /**
         * Setting up navigation controller
         */
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)
    }


    /**
     * Creating hide and show navigation bar function for using in all pages
     */
    fun hideNavigationBar() {
        nav_view.postDelayed(
            {
                nav_view.gone()
            }, 0
        )
    }

    fun showNavigationBar() {
        nav_view.postDelayed(
            {
                nav_view.visible()
            }, 500
        )
    }
}