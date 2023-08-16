package com.route.islmai.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islmai.R
import com.route.islmai.ui.home.HomeActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startHomeAcitivty()
    }

    private fun startHomeAcitivty() {

        Handler(Looper.getMainLooper()).postDelayed(// lambda way
            {
                val intent = Intent(this@SplashScreen, HomeActivity::class.java)
                startActivity(intent)
            },
            2000
        )
//         postDelayed(object :Runnable(){normal way
//
//                    override fun run() {
//                        val intent= Intent(this@SplashScreen,HomeActivity::class.java)
//                    }
//                },2000)

    }
}