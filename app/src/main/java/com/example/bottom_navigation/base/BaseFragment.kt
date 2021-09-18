package com.example.bottom_navigation.base

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.bottom_navigation.MainActivity


/**
 * This fragment is parent of our fragments.
 * We declare onCreateView, pressedBack Function, getStatusBarColor
 */
abstract class BaseFragment : Fragment(), IFragmentInterface, LifecycleObserver {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutID(), container, false)
    }

    override fun onResume() {
        super.onResume()

        val activity = activity as MainActivity

        /**
         * Setting up statusBar color by getStatusBarColor function
         */
        activity.window.statusBarColor =
            ContextCompat.getColor(requireContext(), getStatusBarColor())

        if (isNavigationBarVisible())
            activity.showNavigationBar()
        else
            activity.hideNavigationBar()

        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                pressedBack()
            }
        })
    }

    private fun pressedBack() {
        val navHostFragment = this.parentFragment as NavHostFragment?
        if (navHostFragment?.childFragmentManager?.backStackEntryCount == 1)
            popUp()
        else
            navHostFragment?.findNavController()?.navigateUp()
    }

    /**
     * On the onBoard Fragment catching backStackCount and showing pop-up
     */
    private fun popUp(){
        AlertDialog.Builder(requireContext())
            .setTitle("Uyarı")
            .setMessage("Çıkmak istediğinize emin misiniz?")
            .setCancelable(false)
            .setNegativeButton("Evet") { _, _ ->
                activity?.finish()
            }
            .setPositiveButton("Hayır") { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    abstract fun getLayoutID(): Int

    abstract fun getStatusBarColor(): Int
}