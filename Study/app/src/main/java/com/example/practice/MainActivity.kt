package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())

        val imageList = arrayListOf<Int>()

        imageList.add(R.drawable.photo_1)
        imageList.add(R.drawable.photo_2)
        imageList.add(R.drawable.photo_3)
        imageList.add(R.drawable.photo_1)
        imageList.add(R.drawable.photo_2)
        imageList.add(R.drawable.photo_3)
        imageList.add(R.drawable.photo_1)
        imageList.add(R.drawable.photo_2)
        imageList.add(R.drawable.photo_3)

        Thread {
            for(image in imageList) {
                handler.post {
                    binding.iv.setImageResource(image)
                }
                Thread.sleep(2000)
            }
        }.start()
    }
}
        /*setContentView(R.layout.activity_main)
        val a = A()
        val b = B()

        a.start()
        a.join()//중간에 스레드 B와 바꾸지 않음
        b.start()

    }

    class A : Thread(){
        override fun run() {
            super.run()
            for(i in 1..1000){
                Log.d("test", "first : $i")
            }
        }
    }

    class B : Thread(){
        override fun run() {
            super.run()
            for(i in 1000 downTo 1){
                Log.d("test", "second : $i")
            }
        }
    }*/