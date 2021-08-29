package com.example.kotlincleanarchitecture.presentation.fragment.splash.model


data class UsersData(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UsersDataItem>,
    val support: Support
)