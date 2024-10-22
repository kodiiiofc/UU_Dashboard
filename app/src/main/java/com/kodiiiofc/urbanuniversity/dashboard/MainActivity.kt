package com.kodiiiofc.urbanuniversity.dashboard

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kodiiiofc.urbanuniversity.dashboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RecyclerViewFragment(), "RecyclerView")
            .commit()
    }

    override fun onBackPressed() {
        val backStackCount = supportFragmentManager.backStackEntryCount
        if (backStackCount > 0) {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            if (currentFragment is ClickableCard) {
                currentFragment.onBackPressed()
            }
        }
        else super.onBackPressed()
    }

}