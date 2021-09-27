package com.logtog.businesscard.ui

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.logtog.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()

        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> {
                binding.buttonClose.setColorFilter(Color.WHITE)
            } // Night mode is active, we're using dark theme
        }
    }

    private fun insertListener() {
        binding.buttonClose.setOnClickListener {
            finish()
        }
        binding.buttonConfirm.setOnClickListener {

        }
    }
}