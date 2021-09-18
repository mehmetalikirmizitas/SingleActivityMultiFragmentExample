package com.example.bottom_navigation.ui

import com.example.bottom_navigation.R
import com.example.bottom_navigation.base.BaseFragment

class MyDecksFragment : BaseFragment() {


    /**
     * Setting up Fragment Layout and status bar color by using baseFragment
     */
    override fun getLayoutID(): Int = R.layout.fragment_my_decks
    override fun getStatusBarColor(): Int = R.color.my_decks_screen_gradient_start
}