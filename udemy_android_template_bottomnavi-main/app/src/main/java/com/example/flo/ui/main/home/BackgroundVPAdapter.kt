package com.example.flo.ui.main.home

import android.widget.ImageView
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class BackgroundVPAdapter(fragment:Fragment) : FragmentStateAdapter(fragment){

    private val fragmentlist : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment = fragmentlist[position]

    fun addFragment(fragment : Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1)
    }
}
