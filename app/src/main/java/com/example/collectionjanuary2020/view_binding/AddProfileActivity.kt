package com.example.collectionjanuary2020.view_binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionjanuary2020.databinding.ExProfileViewBindingBinding

class AddProfileActivity : AppCompatActivity() {
    private lateinit var binding: ExProfileViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ExProfileViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textTitle.text = "title profile"
        binding.buttonAuthenticate.text = "button profile"
    }
}