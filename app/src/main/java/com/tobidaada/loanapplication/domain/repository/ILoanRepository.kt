package com.tobidaada.loanapplication.domain.repository

import com.tobidaada.loanapplication.domain.models.Loan

interface ILoanRepository {
    suspend fun getLoans(): List<Loan>
}