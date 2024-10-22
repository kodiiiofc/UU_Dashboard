package com.kodiiiofc.urbanuniversity.dashboard

import androidx.fragment.app.FragmentManager

interface ClickableCard {
    fun onClick(fragmentManager: FragmentManager)
    fun onBackPressed()
}