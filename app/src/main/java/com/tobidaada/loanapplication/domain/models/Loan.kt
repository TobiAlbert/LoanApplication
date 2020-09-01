package com.tobidaada.loanapplication.domain.models

data class Loan(
    val id: String,
    val createdAt: String,
    val name: String,
    val avatar: String,
    val amount: Double,
    val isLoanApproved: Boolean
)