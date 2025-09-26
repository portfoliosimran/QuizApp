package com.sandhu.quizapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sandhu.quizapp.MainActivity
import com.sandhu.quizapp.R
import com.sandhu.quizapp.utils.Constants

class ResultActivity : AppCompatActivity() {
    private lateinit var userNameText: TextView
    private lateinit var scoreText: TextView
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        userNameText = findViewById(R.id.username_text_view)
        scoreText = findViewById(R.id.score_text_view)
        finishButton = findViewById(R.id.finish_btn)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val userName = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.SCORE, 0)

        scoreText.text = "Your score is $score out of $totalQuestions"
        userNameText.text = userName

        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}