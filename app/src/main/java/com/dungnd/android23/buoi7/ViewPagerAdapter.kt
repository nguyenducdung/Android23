package com.dungnd.android23.buoi7

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dungnd.android23.buoi7.fragment.HomeOneFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeOneFragment()
            1 -> Buoi7Fragment()
            2 -> Buoi7HaiFragment()
            else -> HomeOneFragment()
        }
    }
}