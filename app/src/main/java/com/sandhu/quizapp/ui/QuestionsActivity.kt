package com.sandhu.quizapp.ui

import android.content.Intent
import android.graphics.Typeface
import android.graphics.Typeface.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.sandhu.quizapp.R
import com.sandhu.quizapp.model.Questions
import com.sandhu.quizapp.utils.Constants
import androidx.core.graphics.toColorInt

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView
    private lateinit var buttonCheck: Button

    private lateinit var questionsList: MutableList<Questions>
    private var questionCounter = 1
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Questions
    private var isAnswered = false
    private lateinit var userName: String
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progress_bar)
        textViewProgress = findViewById(R.id.progress_text_view)
        textViewQuestion = findViewById(R.id.questions_text_view)
        flagImage = findViewById(R.id.flag_image)

        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)
        buttonCheck = findViewById(R.id.button_check)

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        buttonCheck.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        Log.d("questionSize", "size of questions list is: ${questionsList.size}")

        showNextQuestion()

        if (intent.hasExtra(Constants.USER_NAME)){
            userName = intent.getStringExtra(Constants.USER_NAME)!!
        }
    }

    private fun showNextQuestion() {

        if (questionCounter <= questionsList.size) {
            buttonCheck.text = "CHECK"

            resetOptions()
            val question = questionsList[questionCounter - 1]
            currentQuestion = question
            flagImage.setImageResource(question.image)
            progressBar.progress = questionCounter
            textViewProgress.text = "$questionCounter/${progressBar.max}"
            textViewQuestion.text = question.question
            textViewOptionOne.text = question.optionOne
            textViewOptionTwo.text = question.optionTwo
            textViewOptionThree.text = question.optionThree
            textViewOptionFour.text = question.optionFour

        } else {
            buttonCheck.text = "FINISH"

            Intent(this, ResultActivity::class.java).also {
                it.putExtra(Constants.USER_NAME, userName)
                it.putExtra(Constants.SCORE, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionsList.size)
                startActivity(it)
                finish()
            }
        }

        questionCounter++
        isAnswered = false
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)

        for (option in options) {
            option.setTextColor("#7A8089".toColorInt())
            option.typeface = DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_border_bg
            )
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()
        selectedAnswer = selectedOptionNumber
        textView.setTextColor("#363A43".toColorInt())
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
        textView.setTypeface(textView.typeface, Typeface.BOLD)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.text_view_option_one -> {
                selectedOption(textViewOptionOne, 1)
            }

            R.id.text_view_option_two -> {
                selectedOption(textViewOptionTwo, 2)
            }

            R.id.text_view_option_three -> {
                selectedOption(textViewOptionThree, 3)
            }

            R.id.text_view_option_four -> {
                selectedOption(textViewOptionFour, 4)
            }

            R.id.button_check -> {
                if (!isAnswered) {
                    checkAnswer()
                } else {
                    showNextQuestion()
                }

                selectedAnswer = 0
            }
        }
    }

    private fun checkAnswer() {
        isAnswered = true

        if (selectedAnswer != currentQuestion.correctAnswer) {
            when (selectedAnswer) {
                1 -> textViewOptionOne.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    R.drawable.incorrect_option_border_bg
                )
                2 -> textViewOptionTwo.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    R.drawable.incorrect_option_border_bg
                )
                3 -> textViewOptionThree.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    R.drawable.incorrect_option_border_bg
                )
                4 -> textViewOptionFour.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    R.drawable.incorrect_option_border_bg
                )
            }
        } else {
            score++
        }

        buttonCheck.text = "NEXT"
        showSolution()
    }

    private fun showSolution() {
        val correctAnswer = currentQuestion.correctAnswer

        when (correctAnswer) {
            1 -> textViewOptionOne.background = ContextCompat.getDrawable(
                this@QuestionsActivity,
                R.drawable.correct_option_border_bg
            )

            2 -> textViewOptionTwo.background = ContextCompat.getDrawable(
                this@QuestionsActivity,
                R.drawable.correct_option_border_bg
            )

            3 -> textViewOptionThree.background = ContextCompat.getDrawable(
                this@QuestionsActivity,
                R.drawable.correct_option_border_bg
            )

            4 -> textViewOptionFour.background = ContextCompat.getDrawable(
                this@QuestionsActivity,
                R.drawable.correct_option_border_bg
            )
        }
    }
}