package com.camille.whatbeeryouare

import android.util.Log
import java.lang.IndexOutOfBoundsException

class QuestionStore {
    companion object {
        val questions: List<Question> = listOf(
            Question("Носишь ли ты кепки?", listOf(false, true, true, true)),
            Question("Ты любишь кошачьи ушки?", listOf(false, false, true, true)),
            Question("Ты любишь минимализм?", listOf(true, true, false, true)),
            Question("Нравится Довод Нолона?", listOf(true, false, false, false)),
            Question("Вы серьезный человек?", listOf(false, true, false, false)),
            Question("Вы считаете себя многогранной личностью?", listOf(true, false, true, false)),
            Question("Вам нравится Петербург?", listOf(false, false, false, true))
        )
        // ye ge yi i
        var letters = mutableListOf(0, 0, 0, 0)

        fun parseResult(): String {
            var maxElement = 0
            for (each in letters.indices) {
                if (letters[maxElement] < letters[each]) {
                    maxElement = each
                }
            }
            return when (maxElement) {
                0 -> "Вы Є"
                1 -> "Вы Ґ"
                2 -> "Вы Ї"
                3 -> "Вы І"
                else -> "Вы никто"
            }
        }

        fun navigate(currentPosition: Int, answer: Boolean): Int {
            letters.indices.forEach {
                if (
                    if (answer)
                        questions[currentPosition].pointsList[it]
                    else
                        questions[currentPosition].pointsList[it].not()
                )
                    letters[it]+=1
            }
            return chooseNextFragment(currentPosition)
        }
        fun chooseNextFragment(currentPosition: Int): Int {
            if (currentPosition < questions.size-1)
                return currentPosition+1
            throw IndexOutOfBoundsException()
        }

    }
}

class Question (
    val title: String,
    val pointsList: List<Boolean>
)