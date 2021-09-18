package com.example.bottom_navigation.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.bottom_navigation.R
import com.example.bottom_navigation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {


    /**
     * Setting up Fragment Layout and status bar color by using baseFragment
     */
    override fun getLayoutID(): Int = R.layout.fragment_profile
    override fun getStatusBarColor(): Int = R.color.profile_screen_gradient_start

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Navigate to avatar Change screen when clicked edit button
         */
        editButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_avatarChangeFragment)
        }
    }
}