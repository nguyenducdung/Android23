package com.dungnd.android23.buoi7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.dungnd.android23.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class Buoi7BarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7_bar)
        val vpPage = findViewById<ViewPager2>(R.id.vpPage)
        val bnvData = findViewById<BottomNavigationView>(R.id.bnvData)
        val adapter = ViewPagerAdapter(this)
        vpPage.adapter = adapter
        //disable cái vuốt (swipe)
        vpPage.isUserInputEnabled = false

        bnvData.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home1 -> {
                    vpPage.currentItem = 0
                }
                R.id.home2 -> {
                    vpPage.currentItem = 1
                }
                R.id.home3 -> {
                    vpPage.currentItem = 2
                }
                else -> {
                    vpPage.currentItem = 3
                }
            }

            return@setOnItemSelectedListener true
        }
    }
}