package com.meetozan.cityinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashAcitivty : AppCompatActivity() {

    companion object{
        const val ANIMATION_TIME: Long = 6000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_acitivty)

        Handler(this.mainLooper).postDelayed({
            startActivity(Intent(this@SplashAcitivty, MainActivity::class.java))
            finish()
        }, ANIMATION_TIME)
    }
}