package com.example.guruwake_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_check.*

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)


        // HowManyActivityから値を受け取る
        val memberL = intent.getStringArrayListExtra("MEMBER_L")
        val groupNum = intent.getStringExtra("GROUP_NUM")


        // ツールバーの設定
        setSupportActionBar(check_tb)
        supportActionBar?.let {

            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        } ?: IllegalAccessException("Toolbar cannot be null")


        // メンバーリストを設定
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memberL)
        member_check_lv.adapter = adapter

        // テキストを設定
        check_txt.text = "を" + groupNum + "個のグループに分ける"

        // 決定ボタンの処理
        decide_btn.setOnClickListener {

            // 画面遷移
            val intent = Intent(application, ResultActivity::class.java)
            intent.putExtra("MEMBER_L", memberL)     // memberLをCheckActivityに送る
            intent.putExtra("GROUP_NUM", groupNum)   // groupNumをCheckActivityに送る
            startActivity(intent)
        }
    }
}
