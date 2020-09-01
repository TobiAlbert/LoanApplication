package com.tobidaada.loanapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tobidaada.loanapplication.domain.models.Loan
import com.tobidaada.loanapplication.domain.usecase.GetLoansUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getLoansUseCase: GetLoansUseCase
): ViewModel() {

    private val _loans = MutableLiveData<List<Loan>>()
    fun loans(): LiveData<List<Loan>> = _loans

    fun getLoans() {
        viewModelScope.launch {
            val loans = getLoansUseCase.execute()
            _loans.postValue(loans)
        }
    }
}