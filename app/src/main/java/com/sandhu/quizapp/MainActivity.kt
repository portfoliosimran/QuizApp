package com.sandhu.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sandhu.quizapp.ui.QuestionsActivity
import com.sandhu.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var editTextName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.button_start)
        editTextName = findViewById(R.id.nameEdt)

        startButton.setOnClickListener {
            if (editTextName.text.isNotEmpty()) {
                Intent(this, QuestionsActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            } else {
                editTextName.error = "Please enter your name"
            }
        }

        editTextName.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                startButton.performClick()  // Simulates button click
                true  // return true = handled
            } else {
                false
            }
        }


    }
}
