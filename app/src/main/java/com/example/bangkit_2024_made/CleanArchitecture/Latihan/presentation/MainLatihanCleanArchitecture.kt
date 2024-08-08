package com.example.bangkit_2024_made.CleanArchitecture.Latihan.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bangkit_2024_made.databinding.ActivityMainLatihanCleanArchitectureBinding

class MainLatihanCleanArchitecture : AppCompatActivity() {
    private lateinit var binding: ActivityMainLatihanCleanArchitectureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainLatihanCleanArchitectureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = MainViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        viewModel.setName("Dicoding")
        viewModel.message.observe(this) {
            binding.tvWelcome.text = it.welcomeMessage
        }
    }
}