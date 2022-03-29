package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentAlbumBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

//fragment 상속받음 fragment 기능 사용
class AlbumFragment : Fragment() {
    lateinit var binding: FragmentAlbumBinding
    private val information = arrayListOf("수록곡", "상세정보", "영상")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)


        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        }

//        binding.songLalacLayout.setOnClickListener{
//            Toast.makeText(activity, "LILAC", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.songMixonTg.setOnClickListener{
//            setMixStatus(false)
//        }
//        binding.songMixoffTg.setOnClickListener{
//            setMixStatus(true)
//        }
        val albumAdapter = AlbumVPAdapter(this)
        binding.albumContentVp.adapter = albumAdapter

        TabLayoutMediator(binding.albumContentTb, binding.albumContentVp){
            tab, position ->
            tab.text = information[position]
        }.attach()

        return binding.root
    }

//    fun setMixStatus(isRandom: Boolean){
//        if(isRandom){
//            binding.songMixonTg.visibility = View.VISIBLE
//            binding.songMixoffTg.visibility = View.GONE
//        }
//        else{
//            binding.songMixonTg.visibility = View.GONE
//            binding.songMixoffTg.visibility = View.VISIBLE
//        }
//    }
}