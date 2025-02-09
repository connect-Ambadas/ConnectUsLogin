package com.test.sum.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.test.sum.R
import com.test.sum.databinding.ActivityLoginBinding
import com.test.sum.repository.AuthRepository

class LoginActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // ✅ Step 1: Initialize Repository & ViewModelFactory
        val repository = AuthRepository()
        val factory = LoginViewModelFactory(repository)

        // ✅ Step 2: Initialize ViewModel
        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        // ✅ Step 3: Set up Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel  // ✅ Now viewModel is initialized

        viewModel.navigateToHome.observe(this) { shouldNavigate ->
            if (shouldNavigate) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

    }
}