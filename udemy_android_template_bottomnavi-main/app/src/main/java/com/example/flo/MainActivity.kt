package com.example.flo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.flo.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var song: Song = Song()
    private var gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("실행", "메인엑티비티 실행")
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FLO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputDummySongs()
        initBottomNavigation()

//        val song = Song(
//            binding.mainMiniplayerTitleTv.text.toString(),
//            binding.mainMiniplayerSingerTv.text.toString(),
//            0,
//            60,
//            false,
//            "music_lilac"
//        );

        //Log.d("Song", song.title + song.singer)

        binding.mainPlayerCl.setOnClickListener {
            //startActivity(Intent(this, SongActivity::class.java));
            val editor = getSharedPreferences("song", MODE_PRIVATE).edit()
            editor.putInt("songId", song.id)
            editor.apply()

            var intent = Intent(this, SongActivity::class.java)
            startActivity(intent)
        }
        initBottomNavigation()


    }

    //UI 초기화 하기에 안정적
    override fun onStart() {
        super.onStart()
//        var sharedPreferences = getSharedPreferences("song", MODE_PRIVATE)
//        val songJson = sharedPreferences.getString("songData", null)
//
//        song = if(songJson == null){
//            Song("라일락", "아이유(IU)", 0, 60, false, "music_lilac")
//        }else{
//            gson.fromJson(songJson, Song::class.java)
//        }

        val spf = getSharedPreferences("song", MODE_PRIVATE)
        val songId = spf.getInt("songId", 0)

        val songDB = SongDatabase.getInstance(this)!!

        song = if(songId ==0) {
            songDB.songDao().getSongs(1)
        }else {
            songDB.songDao().getSongs(songId)
        }

        Log.d("song ID", song.id.toString())
        setMiniPlayer(song)
    }

    //bottom navigation 코드
    private fun initBottomNavigation() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun setMiniPlayer(song: Song) {
        binding.mainMiniplayerTitleTv.text = song.title
        binding.mainMiniplayerSingerTv.text = song.singer
        binding.mainMiniplayerProgressSb.progress = (song.second * 100000) / song.playTime
    }

    private fun inputDummySongs() {
        Log.d("실행", "함수는 실행됨")
        val songDB = SongDatabase.getInstance(this)!!
        val songs = songDB.songDao().getSongs()

        if (songs.isNotEmpty())
            return

        songDB.songDao().insert(
            Song(
                "Lilac",
                "아이유 (IU)",
                0,
                200,
                false,
                "music_lilac",
                R.drawable.img_album_exp2,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Flu",
                "아이유 (IU)",
                0,
                200,
                false,
                "music_flu",
                R.drawable.img_album_exp2,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Butter",
                "방탄소년단 (BTS)",
                0,
                190,
                false,
                "music_butter",
                R.drawable.img_album_exp,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Next Level",
                "에스파 (AESPA)",
                0,
                210,
                false,
                "music_next",
                R.drawable.img_album_exp3,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "ONE",
                "아스트로 (ASTRO)",
                0,
                210,
                false,
                "music_next",
                R.drawable.img_album_exp7,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Stardust",
                "아스트로 (ASTRO)",
                0,
                210,
                false,
                "music_next",
                R.drawable.img_album_exp7,
                false,
            )
        )

        songDB.songDao().insert(
            Song(
                "Someone Else",
                "아스트로 (ASTRO)",
                0,
                210,
                false,
                "music_next",
                R.drawable.img_album_exp7,
                false,
            )
        )


        songDB.songDao().insert(
            Song(
                "Candy Sugar Pop",
                "아스트로 (ASTRO)",
                0,
                210,
                false,
                "music_next",
                R.drawable.img_album_exp8,
                false,
            )
        )


        songDB.songDao().insert(
            Song(
                "Boy with Luv",
                "방탄소년단 (BTS)",
                0,
                230,
                false,
                "music_lilac",
                R.drawable.img_album_exp4,
                false,
            )
        )


        songDB.songDao().insert(
            Song(
                "BBoom BBoom",
                "모모랜드 (MOMOLAND)",
                0,
                240,
                false,
                "music_bboom",
                R.drawable.img_album_exp5,
                false,
            )
        )


        val _songs = songDB.songDao().getSongs()
        Log.d("DB data", _songs.toString())
    }
}