package com.marcelodonato.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startMainActivity()
        }, 5000.toLong())
    }


    private fun startMainActivity() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }

}