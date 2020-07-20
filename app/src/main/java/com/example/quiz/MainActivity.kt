package com.example.quiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val quiz: List<String> = listOf("1+1 = 50" , "2+2 = 4", "3+3=6", "4-4=8", "1+1=2", "3+3=3",
        "5+5=10", "7+7 = 14", "8+8=16", "10+10=10")
    val answar:List<Boolean> = listOf(false, true, true, false, true, false, true, true, true, false)
    private var count:Int = 1
    private var score:Int = 0
    private var display:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtQuiz!!.text = quiz[count-1]
        btnO.setOnClickListener {
            //true 일때
            if(count <= 10) {
                //정답확인
                if(answar[count-1]){
                    Toast.makeText(this, "정답입니다.", Toast.LENGTH_SHORT).show()
                    score+=10
                }
                else{
                    Toast.makeText(this, "오답입니다.", Toast.LENGTH_SHORT).show()
                }
                //n/10
                display = (count+1).toString() + "/10"
                txtCount!!.text = display
                if(count<10) {
                    txtQuiz!!.text = quiz[count]  //다음문제
                }
                else {
                    Toast.makeText(this, "모든 문제를 풀었습니다.", Toast.LENGTH_SHORT).show()
                    txtQuiz!!.text = score.toString()
                    if(score <= 20){
                        txtQuiz.setTextColor(Color.parseColor("#FF0000"))
                    }
                    else if(score<=50){
                        txtQuiz.setTextColor(Color.parseColor("#FF8224"))
                    }
                    else if(score<=80){
                        txtQuiz.setTextColor(Color.parseColor("#FFCD12"))
                    }
                    else{
                        txtQuiz.setTextColor(Color.parseColor("#63AA00"))
                    }
                }
                count++
            }
        }

        btnX.setOnClickListener {
            //false 일때
            if(count <= 10) {
                if(!answar[count-1]){
                    Toast.makeText(this, "정답입니다.", Toast.LENGTH_SHORT).show()
                    score+=10
                }
                else{
                    Toast.makeText(this, "오답입니다.", Toast.LENGTH_SHORT).show()
                }

                display = (count + 1).toString() + "/10"
                txtCount!!.text = display
                if(count < 10) {
                    txtQuiz!!.text = quiz[count]
                }
                else {
                    Toast.makeText(this, "모든 문제를 풀었습니다.", Toast.LENGTH_SHORT).show()
                    txtQuiz!!.text = score.toString()
                    if(score <= 20){
                        txtQuiz.setTextColor(Color.parseColor("#FF0000"))
                    }
                    else if(score<=50){
                        txtQuiz.setTextColor(Color.parseColor("#FF8224"))
                    }
                    else if(score<=80){
                        txtQuiz.setTextColor(Color.parseColor("#FFCD12"))
                    }
                    else{
                        txtQuiz.setTextColor(Color.parseColor("#63AA00"))
                    }
                }
                count++
            }

        }
    }
}
