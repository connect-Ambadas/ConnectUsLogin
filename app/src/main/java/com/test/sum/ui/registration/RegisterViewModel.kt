package com.test.sum.ui.registration

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.sum.data.model.registration.Admin
import com.test.sum.repository.AuthRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: AuthRepository): ViewModel() {

    val admin = ObservableField(Admin())
    val isLoading = ObservableField<Boolean>(false)
    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean> get() = _navigateToHome

    fun onSubmit(){
        viewModelScope.launch {
            try {
                val adminData = admin.get()
                val response = repository.register(adminData!!)
                isLoading.set(false)
                if (response.body()?.responseCode.equals("00")) {
                    _navigateToHome.postValue(true)
                } else {
                    System.out.println("failure::>>>>>")
                }
            } catch (e: Exception) {
                _navigateToHome.postValue(true)
            }
        }
    }
}