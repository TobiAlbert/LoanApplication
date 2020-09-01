package com.tobidaada.loanapplication.data.models

import com.google.gson.annotations.SerializedName
import com.tobidaada.loanapplication.domain.models.Loan

data class LoanNetwork(
    @SerializedName("id")
    val id: String,

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("avatar")
    val avatar: String,

    @SerializedName("amount")
    val amount: Double,

    @SerializedName("isLoanApproved")
    val isLoanApproved: Boolean
) {
    fun toDomain(): Loan =
        Loan(
            id = id,
            createdAt = createdAt,
            name = name,
            avatar = avatar,
            amount = amount,
            isLoanApproved = isLoanApproved
        )
}