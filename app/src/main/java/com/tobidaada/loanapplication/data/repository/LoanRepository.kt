package com.tobidaada.loanapplication.data.repository

import com.cyberspace.cyberpaysdk.CyberpaySdk
import com.tobidaada.loanapplication.data.interfaces.IRemoteDataSource
import com.tobidaada.loanapplication.domain.models.Loan
import com.tobidaada.loanapplication.domain.repository.ILoanRepository

class LoanRepository(
    private val remoteDataSource: IRemoteDataSource
): ILoanRepository {
    override suspend fun getLoans(): List<Loan> = remoteDataSource.getLoans()
}