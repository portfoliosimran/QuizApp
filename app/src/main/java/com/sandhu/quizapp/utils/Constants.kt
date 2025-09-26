package com.sandhu.quizapp.utils

import com.sandhu.quizapp.R
import com.sandhu.quizapp.model.Questions

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val SCORE = "correct_answers"
    fun getQuestions(): MutableList<Questions> {
        val questionsList = mutableListOf<Questions>()

        val quest1 = Questions(
            id = 1,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_italy,
            optionOne = "Italy",
            optionTwo = "India",
            optionThree = "Iran",
            optionFour = "Ireland",
            correctAnswer = 1
        )

        val quest2 = Questions(
            id = 2,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_argentina,
            optionOne = "Armenia",
            optionTwo = "Argentina",
            optionThree = "Australia",
            optionFour = "Austria",
            correctAnswer = 2
        )

        val quest3 = Questions(
            id = 3,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_brazil,
            optionOne = "Belarus",
            optionTwo = "Belgium",
            optionThree = "Bangladesh",
            optionFour = "Brazil",
            correctAnswer = 4
        )

        val quest4 = Questions(
            id = 4,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_france,
            optionOne = "Finland",
            optionTwo = "Fiji",
            optionThree = "France",
            optionFour = "None of the above",
            correctAnswer = 3
        )

        val quest5 = Questions(
            id = 5,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_finland,
            optionOne = "Finland",
            optionTwo = "Fiji",
            optionThree = "France",
            optionFour = "None of the above",
            correctAnswer = 1
        )

        val quest6 = Questions(
            id = 6,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_germany,
            optionOne = "Gambia",
            optionTwo = "Germany",
            optionThree = "Georgia",
            optionFour = "Greece",
            correctAnswer = 2
        )

        val quest7 = Questions(
            id = 7,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_nigeria,
            optionOne = "Netherlands",
            optionTwo = "Nicaragua",
            optionThree = "Nigeria",
            optionFour = "Nepal",
            correctAnswer = 3
        )

        val quest8 = Questions(
            id = 8,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_romania,
            optionOne = "Russia",
            optionTwo = "Rwanda",
            optionThree = "Czech Republic",
            optionFour = "Romania",
            correctAnswer = 4
        )

        val quest9 = Questions(
            id = 9,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_spain,
            optionOne = "Serbia",
            optionTwo = "Spain",
            optionThree = "Saudi Arabia",
            optionFour = "Slovenia",
            correctAnswer = 2
        )

        val quest10 = Questions(
            id = 10,
            question = "What country does this flag belong to?",
            image = R.drawable.flag_of_india,
            optionOne = "Serbia",
            optionTwo = "Japan",
            optionThree = "India",
            optionFour = "Sri Lanka",
            correctAnswer = 3
        )



        questionsList.add(quest1)
        questionsList.add(quest2)
        questionsList.add(quest3)
        questionsList.add(quest4)
        questionsList.add(quest5)
        questionsList.add(quest6)
        questionsList.add(quest7)
        questionsList.add(quest8)
        questionsList.add(quest9)
        questionsList.add(quest10)

        return questionsList
    }
}