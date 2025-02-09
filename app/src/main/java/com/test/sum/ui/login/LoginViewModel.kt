package com.test.sum.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.sum.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: AuthRepository) : ViewModel() {

    val email = ObservableField<String>()
    val password = ObservableField<String>()
    val isLoading = ObservableField<Boolean>(false)
    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean> get() = _navigateToHome

    fun login() {
        viewModelScope.launch {
            isLoading.set(true)
            try {
                val response = repository.login(email.get() ?: "", password.get() ?: "")
                isLoading.set(false)
                if (response.body()?.responseCode.equals("00")) {
                    _navigateToHome.postValue(true)
                } else {
                    System.out.println("failure::>>>>>")
                }
            } catch (e: Exception) {
                isLoading.set(false)
            }
        }
    }
}