package com.tobidaada.loanapplication.data.interfaces

import com.tobidaada.loanapplication.domain.models.Loan

interface IRemoteDataSource {
    suspend fun getLoans(): List<Loan>
}