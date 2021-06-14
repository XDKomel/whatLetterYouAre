package com.camille.whatbeeryouare

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.navigation.findNavController
import java.lang.IndexOutOfBoundsException

class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)
        view.findViewById<TextView>(R.id.title_question).text = QuestionStore.questions[
            QuestionFragmentArgs.fromBundle(requireArguments()).agrs
        ].title

        view.findViewById<Button>(R.id.button_next).setOnClickListener {
            view.findNavController().navigate(
                try {
                    QuestionFragmentDirections.actionQuestionFragmentSelf(
                        QuestionStore.navigate(
                            QuestionFragmentArgs.fromBundle(requireArguments()).agrs,
                            view.findViewById<RadioGroup>(R.id.buttons_group).checkedRadioButtonId == R.id.radioButton1
                        )
                    )
                } catch (e: IndexOutOfBoundsException) {
                    Log.i("TAG", QuestionStore.letters[0].toString())
                    QuestionFragmentDirections.actionQuestionFragmentToResultFragment()
                }
            )
        }
        return view
    }

}