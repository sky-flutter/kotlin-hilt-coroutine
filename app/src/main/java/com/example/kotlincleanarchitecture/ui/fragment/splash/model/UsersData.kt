package com.example.kotlincleanarchitecture.ui.fragment.splash.model


data class UsersData(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: ArrayList<UsersDataItem>,
    val support: Support
)