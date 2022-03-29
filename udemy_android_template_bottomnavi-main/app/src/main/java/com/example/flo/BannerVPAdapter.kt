package com.example.flo

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class BannerVPAdapter(fragment:Fragment) : FragmentStateAdapter(fragment){

    private val fragmentlist : ArrayList<Fragment> = ArrayList()

    /*override fun getItemCount(): Int {
        //데이터를 몇개를 전달할 것이냐
        return fragmentlist.size
    }*/
    //=
    override fun getItemCount(): Int = fragmentlist.size

    override fun createFragment(position: Int): Fragment = fragmentlist[position]

    fun addFragment(fragment : Fragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1)
    }
}
