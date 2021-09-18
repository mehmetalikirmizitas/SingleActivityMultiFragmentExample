package com.example.bottom_navigation.ui

import android.os.Bundle
import android.view.View
import com.example.bottom_navigation.R
import com.example.bottom_navigation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_battle.*

class BattleFragment : BaseFragment() {


    /**
     * Setting up Fragment Layout and status bar color by using baseFragment
     */
    override fun getLayoutID(): Int = R.layout.fragment_battle
    override fun getStatusBarColor(): Int = R.color.battle_screen_gradient_start

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /**
         * adjusting the progress of the level progress indicator
         */
        level_progress_indicator.progress = 1
        level_progress_indicator.max = 2
    }
}