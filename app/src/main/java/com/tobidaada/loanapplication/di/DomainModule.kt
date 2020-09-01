package com.tobidaada.loanapplication.di

import com.tobidaada.loanapplication.domain.usecase.GetLoansUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetLoansUseCase(get())}
}