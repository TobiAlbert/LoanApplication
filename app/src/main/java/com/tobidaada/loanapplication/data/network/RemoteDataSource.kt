package com.tobidaada.loanapplication.data.network

import android.util.Log
import com.tobidaada.loanapplication.data.interfaces.IRemoteDataSource
import com.tobidaada.loanapplication.data.network.services.LoanService
import com.tobidaada.loanapplication.domain.models.Loan
import retrofit2.Retrofit

class RemoteDataSource(private val client: LoanService): IRemoteDataSource {
    override suspend fun getLoans(): List<Loan> {
        try {
            val loans = client.getLoans()
            Log.i("Loans", loans.toString())
            return loans.map { it.toDomain() }
        } catch (e: Exception) {
            Log.e("Error", e.toString())
            return emptyList()
        }
    }
}