package com.example.bottom_navigation.ui.avatarChange

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottom_navigation.R
import com.example.bottom_navigation.model.Avatar

class AvatarChangeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * declared selected item -1 for
     */
    var selectedItem = -1
    private lateinit var avatarList: ArrayList<Avatar>

    /**
     * declare view types
     */
    companion object {
        const val TYPE_TEXT = 1
        const val TYPE_AVATAR = 2
    }

    /**
     * Creating viewHolder by view type
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_TEXT) {
            TextViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_text_view_item, parent, false)
            )
        } else {
            AvatarViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_photo_selector_view, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (avatarList[position].viewType == TYPE_TEXT && holder is TextViewHolder) {
            holder.bind(position)
        } else {
            (holder as AvatarViewHolder).bind(position)
            holder.checkboxSelector(position == selectedItem)
        }
    }

    override fun getItemViewType(position: Int): Int = avatarList[position].viewType
    override fun getItemCount(): Int = avatarList.size


    /**
     * Avatar View holder present avatars and checkbox
     */
    @SuppressLint("NotifyDataSetChanged")
    inner class AvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * finding avatar view
         */
        private val imageView: AppCompatImageView = itemView.findViewById(R.id.avatar)

        /**
         * binding avatar view using by list
         */
        fun bind(position: Int) {
            val avatarImage = avatarList[position]
            imageView.setImageResource(avatarImage.imgRes!!)
        }

        /**
         * finding checkBox view
         */
        private val checkbox: AppCompatCheckBox = itemView.findViewById(R.id.check_box)

        /**
         * binding checkbox selector by clicked item
         */
        fun checkboxSelector(status: Boolean) {
            checkbox.isChecked = status
            itemView.setOnClickListener {
                selectedItem = adapterPosition
                notifyDataSetChanged()
            }
        }
    }

    /**
     * Text View holder present just Text
     */
    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * binding textView by id
         */
        private val textView: AppCompatTextView = itemView.findViewById(R.id.recyclerViewTextItem)

        fun bind(position: Int) {
            val recyclerViewModel = avatarList[position]
            textView.text = recyclerViewModel.text
        }
    }

    /**
     * Setting up incoming avatar list on fragment
     */
    fun setAvatars(avatars: ArrayList<Avatar>) {
        this.avatarList = avatars
    }
}