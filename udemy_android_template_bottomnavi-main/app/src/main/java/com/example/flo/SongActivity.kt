package com.example.flo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flo.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    lateinit var binding : ActivitySongBinding

    //Activity 실행 시 처음 실행되는 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        //xml 가져와서 맘대로 쓸거야
        setContentView(binding.root)
        binding.songDownIb.setOnClickListener{
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener{
            setPlayerStatus(false);
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true);
        }
        if(intent.hasExtra("title") && intent.hasExtra("singer")){
            binding.songMusicTitleTv.text = intent.getStringExtra("title")
            binding.songSingerNameTv.text = intent.getStringExtra("singer")
        }

        binding.songRepeatIvOn.setOnClickListener{
            setRepeatStatus(false);
        }
        binding.songRepeatIv.setOnClickListener {
            setRepeatStatus(true);
        }

        binding.songRandomIvOn.setOnClickListener{
            setRandomStatus(false);
        }
        binding.songRandomIv.setOnClickListener {
            setRandomStatus(true);
        }

    }

    fun setPlayerStatus(isPlaying : Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility = View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
        else{
            binding.songMiniplayerIv.visibility = View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }

    fun setRepeatStatus(isRepeat: Boolean){
        if(isRepeat){
            binding.songRepeatIvOn.visibility = View.VISIBLE
            binding.songRepeatIv.visibility = View.GONE
        }
        else{
            binding.songRepeatIvOn.visibility = View.GONE
            binding.songRepeatIv.visibility = View.VISIBLE
        }
    }

    fun setRandomStatus(isRandom: Boolean){
        if(isRandom){
            binding.songRandomIvOn.visibility = View.VISIBLE
            binding.songRandomIv.visibility = View.GONE
        }
        else{
            binding.songRandomIvOn.visibility = View.GONE
            binding.songRandomIv.visibility = View.VISIBLE
        }
    }


}