package com.example.guruwake_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_how_many.*
import kotlinx.android.synthetic.main.activity_who.*

class HowManyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_many)


        // WhoActivityから値を受け取る
        val memberL = intent.getStringArrayListExtra("MEMBER_L")


        // ツールバーの設定
        setSupportActionBar(hm_tb)
        supportActionBar?.let {

            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        } ?: IllegalAccessException("Toolbar cannot be null")


        // 次へボタンの処理
        next_hm_btn.setOnClickListener {

            // 引き渡す値の調整
            val groupNum = group_num_et.text.toString()

            // 画面遷移
            val intent = Intent(application, CheckActivity::class.java)
            intent.putExtra("MEMBER_L", memberL)     // memberLをCheckActivityに送る
            intent.putExtra("GROUP_NUM", groupNum)   // groupNumをCheckActivityに送る
            startActivity(intent)
        }
    }
}
