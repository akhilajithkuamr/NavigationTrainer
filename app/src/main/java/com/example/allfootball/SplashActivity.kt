package com.example.allfootball

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity:AppCompatActivity() {

    private val SPLASH_TIMEOUT :Long=3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()

        },SPLASH_TIMEOUT)
    }
}