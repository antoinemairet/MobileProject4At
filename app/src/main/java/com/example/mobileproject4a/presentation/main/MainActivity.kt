package com.example.mobileproject4a.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mobileproject4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.example.mobileproject4a.presentation.list.ListActivity
import com.example.mobileproject4a.presentation.createaccount.CreateAccountActivity

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    startActivity(Intent(this@MainActivity, ListActivity::class.java))
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setMessage("Account not found")
                        .setTitle("Error")
                        .setPositiveButton("Ok") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(
                login_edit.text.toString().trim(),
                password_edit.text.toString().trim()
            )
        }

        create_account_button.setOnClickListener {

        startActivity(Intent(this@MainActivity, CreateAccountActivity::class.java))
    }

    }


}

