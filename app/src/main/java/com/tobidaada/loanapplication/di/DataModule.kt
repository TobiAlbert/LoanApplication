package com.tobidaada.loanapplication.di

import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import com.tobidaada.loanapplication.BuildConfig
import com.tobidaada.loanapplication.data.interfaces.IRemoteDataSource
import com.tobidaada.loanapplication.data.network.RemoteDataSource
import com.tobidaada.loanapplication.data.network.services.LoanService
import com.tobidaada.loanapplication.data.repository.LoanRepository
import com.tobidaada.loanapplication.domain.repository.ILoanRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single<LoanService> {
        val interceptor = ChuckInterceptor(androidApplication()).showNotification(true)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(client)
            .build()
            .create(LoanService::class.java)
    }

    single<IRemoteDataSource> { RemoteDataSource(get()) }
}

val repositoryModule = module {
    single<ILoanRepository> { LoanRepository(get()) }
}
