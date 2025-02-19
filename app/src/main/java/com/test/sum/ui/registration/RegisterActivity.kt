package com.test.sum.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.test.sum.R
import com.test.sum.databinding.ActivityLoginBinding
import com.test.sum.databinding.ActivityRegisterBinding
import com.test.sum.repository.AuthRepository
import com.test.sum.ui.home.HomeActivity
import com.test.sum.ui.login.LoginViewModel
import com.test.sum.ui.login.LoginViewModelFactory

class RegisterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ✅ Step 1: Initialize Repository & ViewModelFactory
        val repository = AuthRepository()
        val factory = RegisterViewModelFactory(repository)

        // ✅ Step 2: Initialize ViewModel
        viewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        // ✅ Step 3: Set up Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
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