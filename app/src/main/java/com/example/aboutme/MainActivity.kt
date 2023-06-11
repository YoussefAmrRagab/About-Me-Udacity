package com.example.aboutme

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.done.setOnClickListener {
            getUserName()
        }
    }

    private fun getUserName() {
        binding.apply {
            userNameText.text = userName.text
            done.visibility = GONE
            userName.visibility = GONE
            userNameText.visibility = VISIBLE

            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()

            // Hide the keyboard.
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(root.windowToken, 0)
        }
    }
}