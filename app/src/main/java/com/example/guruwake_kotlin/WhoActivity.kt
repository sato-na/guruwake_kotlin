package com.example.guruwake_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_who.*
import kotlin.arrayOf as arrayOf1

class WhoActivity : AppCompatActivity() {

    var memberL:ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_who)


        //ツールバーの設定
        setSupportActionBar(who_tb)
        supportActionBar?.let {

            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        } ?: IllegalAccessException("Toolbar cannot be null")


        // 追加ボタンの処理
        add_btn.setOnClickListener {


            addMember()
        }


        // 次へボタンの処理
        next_who_btn.setOnClickListener {

            // 引き渡す値の調整
            memberL.reverse()

            // 画面遷移
            val intent = Intent(application, HowManyActivity::class.java)
            intent.putExtra("MEMBER_L", memberL)     // memberLをHowManyActivityに送る
            startActivity(intent)
        }
    }


    // 追加ボタンの処理内容
    fun addMember() {

        memberL.add(member_et.text.toString())
        member_et?.text?.clear()
        var memverLR = ArrayList<String>(memberL)
        memverLR.reverse()
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, memverLR)
        member_lv.adapter = adapter
    }
}
