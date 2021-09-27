package com.logtog.businesscard.ui

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.logtog.businesscard.App
import com.logtog.businesscard.R
import com.logtog.businesscard.data.BusinessCard
import com.logtog.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModel.MainViewModelFactory((application as App).repository)
    }

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
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                backgroundColor = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess,Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}