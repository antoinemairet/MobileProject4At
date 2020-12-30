package com.example.mobileproject4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mobileproject4a.R
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_button.setOnClickListener{
            mainViewModel.onClickIncrement("")
        }

        mainViewModel.counter.observe(this, Observer {
            value -> main_text.text = value.toString()
        })
    }


}