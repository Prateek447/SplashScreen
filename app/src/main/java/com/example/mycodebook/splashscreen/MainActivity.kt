package com.example.mycodebook.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var topAnim : Animation
    private  lateinit var btmAnimation: Animation
    private lateinit var log : ImageView
    private lateinit var title : TextView
    private lateinit var subTitle : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
         log = findViewById(R.id.imageView)
         title = findViewById(R.id.textView)
        subTitle = findViewById(R.id.textView2)
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        btmAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)


        log.animation = topAnim
        title.animation =  btmAnimation
        subTitle.animation =  btmAnimation


        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}