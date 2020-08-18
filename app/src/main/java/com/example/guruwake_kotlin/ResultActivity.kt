package com.example.guruwake_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import java.util.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        // CheckActivityから値を受け取る
        val memberL = intent.getStringArrayListExtra("MEMBER_L")
        val groupNum = intent.getStringExtra("GROUP_NUM")


        // グループ分けをして表示する
        var rTxt = ""
        val groupNumI : Int = groupNum.toInt()
        val memberNum = memberL.size
        memberL.shuffle(Random())
        for (n in 1..groupNumI) {

            rTxt += "グループ" + n + "\n"
            var p = memberNum / groupNumI
            if (n <= memberNum % groupNumI) {

                p++
            }
            for (q in 0..p-1) {

                rTxt += "   " + memberL[0] + "\n"
                memberL.remove(memberL[0])
            }
        }
        result_txt.text = rTxt


        // タイトルボタンの処理
        title_btn.setOnClickListener {

            // 画面遷移
            val intent = Intent(application, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
