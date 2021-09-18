package com.example.bottom_navigation.util

import android.view.View


/**
 * extension function to hide or show any view
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}