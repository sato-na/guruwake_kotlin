package com.example.guruwake_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // スタートボタンの処理
        start_btn.setOnClickListener {

            val intent = Intent(application, WhoActivity::class.java)
            startActivity(intent)
        }
    }
}
