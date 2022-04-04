package com.example.flo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding
import me.relex.circleindicator.CircleIndicator3

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homePannelAlbumImg01Iv.setOnClickListener {
            Log.d("msg","앨범 클릭됨")
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, AlbumFragment()).commitAllowingStateLoss()
        }
        //fragment 전환
        binding.homeAlbumImgIv1.setOnClickListener {
            Log.d("msg","앨범 클릭됨")
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm, AlbumFragment()).commitAllowingStateLoss()
        }


        val bannerAdapter =BannerVPAdapter(this)
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val backgroundAdapter = BackgroundVPAdapter(this)
        backgroundAdapter.addFragment(BackgroundFragment(R.drawable.img_first_album_default))
        backgroundAdapter.addFragment(BackgroundFragment(R.drawable.img_album_exp))
        backgroundAdapter.addFragment(BackgroundFragment(R.drawable.img_album_exp2))
        backgroundAdapter.addFragment(BackgroundFragment(R.drawable.img_album_exp3))
        binding.homePannelBackgroundVp.adapter = backgroundAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        var page : ViewPager2 = binding.homePannelBackgroundVp
        var indicator : CircleIndicator3 = binding.homeIndicator
        indicator.setViewPager(page)
        indicator.createIndicators(4, 0)

        return binding.root
    }
}