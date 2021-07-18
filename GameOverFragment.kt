package com.example.androidtrivia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.androidtrivia.databinding.FragmentGameOverBinding
import com.example.androidtrivia.databinding.FragmentGameWonBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =  DataBindingUtil.inflate<FragmentGameOverBinding>(inflater,R.layout.fragment_game_over,container,false)

        binding.tryAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameOverFragment_to_titleFragment)
        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_game_over, container, false)
    }


}

