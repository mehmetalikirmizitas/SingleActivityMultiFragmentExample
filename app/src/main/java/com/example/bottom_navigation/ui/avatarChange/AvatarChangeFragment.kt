package com.example.bottom_navigation.ui.avatarChange

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bottom_navigation.R
import com.example.bottom_navigation.base.BaseFragment
import com.example.bottom_navigation.model.Avatar
import com.example.bottom_navigation.util.TEXT
import kotlinx.android.synthetic.main.fragment_avatar_change.*

class AvatarChangeFragment : BaseFragment() {

    /**
     * Setting up Fragment Layout and status bar color by using baseFragment
     */
    override fun getLayoutID(): Int = R.layout.fragment_avatar_change
    override fun getStatusBarColor(): Int = R.color.avatar_change_screen_color

    override fun isNavigationBarVisible(): Boolean = false


    private lateinit var avatarList: ArrayList<Avatar>
    private var avatarChangeAdapter: AvatarChangeAdapter = AvatarChangeAdapter()


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * creating list and putting data in list
         */
        avatarList = arrayListOf()
        avatarList.apply {
            add(Avatar(TEXT, null, null, AvatarChangeAdapter.TYPE_TEXT))
            add(Avatar(null, false, R.drawable.ic_avatar01, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar02, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar03, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar04, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar05, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar06, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar07, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar08, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar09, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar01, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar02, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar03, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar04, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar05, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar06, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar07, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar08, AvatarChangeAdapter.TYPE_AVATAR))
            add(Avatar(null, false, R.drawable.ic_avatar09, AvatarChangeAdapter.TYPE_AVATAR))
        }

        /**
         * Changing span count by incoming view value
         */
        val layoutManager = GridLayoutManager(requireContext(), 3)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> 3
                    else -> 1
                }
            }
        }

        avatarRecyclerView.layoutManager = layoutManager
        avatarChangeAdapter.setAvatars(avatarList)
        avatarRecyclerView.adapter = avatarChangeAdapter
        avatarChangeAdapter.notifyDataSetChanged()
    }
}