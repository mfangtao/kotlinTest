package com.fangtao.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Activity跳转
         */
        startActivity(Intent(MainActivity@this,Main2Activity::class.java))
    }
}
