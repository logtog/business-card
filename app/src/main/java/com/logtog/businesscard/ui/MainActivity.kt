package com.logtog.businesscard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logtog.businesscard.R
import com.logtog.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}