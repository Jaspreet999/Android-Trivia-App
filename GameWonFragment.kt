package com.example.androidtrivia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.androidtrivia.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameWonBinding>(inflater,
            R.layout.fragment_game_won,container,false)
        setHasOptionsMenu(true)
        binding.nextMatchButton.setOnClickListener {
            findNavController().navigate(R.id.action_gameWonFragment_to_titleFragment)
        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_game_won, container, false)
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu,menu)

        if(startIntentForSharingContent().resolveActivity(requireActivity().packageManager)==null){
            menu.findItem(R.id.share).isVisible = false
        }
    }

    private fun startIntentForSharingContent():Intent{
        return Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"You pass the test on android trivia")
            type = "text/plain"
        }
    }

    private fun getIntentToShare(){
        startActivity(startIntentForSharingContent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> getIntentToShare()
        }
        return super.onOptionsItemSelected(item)
    }


}