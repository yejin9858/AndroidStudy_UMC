package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.example.flo.databinding.ActivitySongBinding
import com.example.flo.databinding.FragmentAlbumBinding
import java.util.zip.Inflater

//fragment 상속받음 fragment 기능 사용
class AlbumFragment : Fragment() {
    lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)


        binding.albumBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        }

        binding.songLalacLayout.setOnClickListener{
            Toast.makeText(activity, "LILAC", Toast.LENGTH_SHORT).show()
        }

        binding.songMixonTg.setOnClickListener{
            setMixStatus(false)
        }
        binding.songMixoffTg.setOnClickListener{
            setMixStatus(true)
        }
        return binding.root
    }

    fun setMixStatus(isRandom: Boolean){
        if(isRandom){
            binding.songMixonTg.visibility = View.VISIBLE
            binding.songMixoffTg.visibility = View.GONE
        }
        else{
            binding.songMixonTg.visibility = View.GONE
            binding.songMixoffTg.visibility = View.VISIBLE
        }
    }
}