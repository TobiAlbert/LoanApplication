package com.tobidaada.loanapplication.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.tobidaada.loanapplication.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUi()
        observeViewModel()

        viewModel.getLoans()
    }

    private fun setupUi() {

    }

    private fun observeViewModel() {
        viewModel.loans().observe(this, Observer {
            it?.let {
                it.forEach { Log.i("MainActivity", "$it") }
            }
        })
    }
}