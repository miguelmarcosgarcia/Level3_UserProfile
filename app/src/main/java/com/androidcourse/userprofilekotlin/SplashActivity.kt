package com.androidcourse.userprofilekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

//To run an action with a delay we make use of a Handler. At the end of the onCreate from
//the SplashActivity use the postDelayed method of a new Handler object to start the, to be
//created in the next step, CreateProfileActivity using an intent.

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Use Handler to wait 1 second before opening the CreateProfileActivity.
        Handler().postDelayed({
            startActivity(
                Intent(
                    this@SplashActivity,
                    CreateProfileActivity::class.java
                )
            )
            /*
            * The SplashActivity must also be finished so that it is removed from the back stack
            * (so that when a user presses the back button the splash screen doesn’t re-open).
            */
            finish()
        }, 1000)//1 second
    }
}
