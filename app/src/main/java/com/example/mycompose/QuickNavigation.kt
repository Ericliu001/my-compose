package com.example.mycompose

import android.net.Uri

data class QuickNavigation(
    val image: Int? = null,
    val title: String,
    val body: String,
    val uri: Uri
)
