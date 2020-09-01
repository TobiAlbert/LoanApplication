package com.tobidaada.loanapplication.data.network.services

import com.tobidaada.loanapplication.data.models.LoanNetwork
import retrofit2.http.GET

interface LoanService {
    @GET("/loans/")
    suspend fun getLoans(): List<LoanNetwork>
}