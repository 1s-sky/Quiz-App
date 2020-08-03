package com.example.quiz

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val question = arrayOf(
        Quiz(R.string.quiz_01, false),
        Quiz(R.string.quiz_02, true),
        Quiz(R.string.quiz_03, true),
        Quiz(R.string.quiz_04, true),
        Quiz(R.string.quiz_05, false),
        Quiz(R.string.quiz_06, false),
        Quiz(R.string.quiz_07, true),
        Quiz(R.string.quiz_08, false),
        Quiz(R.string.quiz_09, true),
        Quiz(R.string.quiz_10, false)
    )

    private var count:Int = 0
    private var score:Int = 0
    private var display:String = ""

    private fun answerCheck(num:Int, answer: Boolean){
        if(question[num].answer == answer){
            Toast.makeText(this, "정답입니다.", Toast.LENGTH_SHORT).show()
            score+=10
        }
        else{
            Toast.makeText(this, "오답입니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun nextQuiz(num: Int) {
        if (count < 9) {
            display = (count + 2).toString() + "/10"
            txtCount!!.text = display
            txtQuiz!!.setText(question[num + 1].quiz_num)
        }
        else {
            display = "10/10"
            showScore()
        }
    }

    private fun showScore(){
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtQuiz!!.setText(question[count].quiz_num)  //기본화면 띄우기
        btnO.setOnClickListener { //버튼 O클릭
            //true 일때
            if(count < 10) {
                //정답체크
                answerCheck(count, true)
                //다음문제 넘어가기
                nextQuiz(count)
                count++
            }
        }

        btnX.setOnClickListener {
            //false 일때
            if(count < 10) {
                //정답체크
                answerCheck(count, false)
                //다음문제 넘어가기
                nextQuiz(count)
                count++
            }

        }
    }
}
