package com.tobidaada.loanapplication.domain.usecase

import com.tobidaada.loanapplication.domain.models.Loan
import com.tobidaada.loanapplication.domain.repository.ILoanRepository

class GetLoansUseCase (private val repo: ILoanRepository) {
    suspend fun execute(): List<Loan> = repo.getLoans()
}