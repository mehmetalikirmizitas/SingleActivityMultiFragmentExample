package com.example.bottom_navigation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.bottom_navigation.R
import com.example.bottom_navigation.base.BaseFragment


class SplashFragment : BaseFragment() {

    /**
     * Setting up Fragment Layout and status bar color by using baseFragment
     */
    override fun getLayoutID(): Int = R.layout.fragment_splash
    override fun getStatusBarColor(): Int = R.color.background_color

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /**
         * Delayed navigation to onBoard Fragments
         */
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_navigation_battle_active)
        }, 3000)
    }

    /**
     * hiding Navigation Bar on splash Fragment
     */
    override fun isNavigationBarVisible(): Boolean = false
}