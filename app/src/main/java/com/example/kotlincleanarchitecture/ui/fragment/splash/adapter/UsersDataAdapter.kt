package com.example.kotlincleanarchitecture.ui.fragment.splash.adapter

import com.example.kotlincleanarchitecture.R
import com.example.kotlincleanarchitecture.databinding.ItemUsersBinding
import com.example.kotlincleanarchitecture.ui.fragment.splash.model.UsersDataItem
import zolve.credit.card.us.base.BaseRecyclerViewAdapter

class UsersDataAdapter : BaseRecyclerViewAdapter<ItemUsersBinding>() {
    private val listUsers = arrayListOf<UsersDataItem>()

    override fun setLayoutItem() = R.layout.item_users

    override fun setCount() = listUsers.size

    override fun onViewReady(holder: ViewHolder<ItemUsersBinding>, position: Int) {
        holder.mBinding.user = listUsers[position]
    }

    fun updateData(listUsers: ArrayList<UsersDataItem>) {
        this.listUsers.addAll(listUsers)
        notifyDataSetChanged()
    }
}