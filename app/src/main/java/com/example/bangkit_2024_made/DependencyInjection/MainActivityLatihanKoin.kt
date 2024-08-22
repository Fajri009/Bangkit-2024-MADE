package com.example.bangkit_2024_made.DependencyInjection

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bangkit_2024_made.databinding.ActivityMainLatihanKoinBinding
import org.koin.android.ext.android.inject

class MainActivityLatihanKoin : AppCompatActivity() {
    lateinit var binding: ActivityMainLatihanKoinBinding
    private val userRepository: UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLatihanKoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sesi = SessionManager(this)
//        userRepository = UserRepository.getInstance(sesi)

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