package com.camille.whatbeeryouare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

class StarterFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_starter, container, false)
        view.findViewById<Button>(R.id.button_start).setOnClickListener {
            view.findNavController().navigate(StarterFragmentDirections.actionStarterFragmentToQuestionFragment(0))
        }
        return view
    }

}