package com.example.hangqrcoute

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hangqrcoute.databinding.FragmentSecondBinding
import com.squareup.picasso.Picasso

class SecondFragment(name: String, url: String) : Fragment(){

    private lateinit var binding : FragmentSecondBinding
    private var name = name
    private var url = "https://api.qrserver.com/v1/create-qr-code/?data=" + url

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)

        binding.idTextView.text = name

        Picasso.get().load(url).into(binding.idImageView)

        return binding.root
    }

}

