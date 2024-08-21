package com.example.bangkit_2024_made.DependencyInjection

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bangkit_2024_made.R
import com.example.bangkit_2024_made.databinding.ActivityMainLatihanKoinBinding

class MainActivityLatihanKoin : AppCompatActivity() {
    lateinit var binding: ActivityMainLatihanKoinBinding
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLatihanKoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sesi = SessionManager(this)
        userRepository = UserRepository.getInstance(sesi)

        if (userRepository.isUserLogin()) {
            moveToHomeActivity()
        }

        binding.btnLogin.setOnClickListener {
            saveSession()
        }
    }

    private fun saveSession() {
        userRepository.loginUser(binding.edUsername.text.toString())
        moveToHomeActivity()
    }

    private fun moveToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}