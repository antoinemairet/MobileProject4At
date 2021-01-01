/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 31/12/20 11:32
 *
 */

package com.example.mobileproject4a.presentation.createaccount

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileproject4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.password_edit
import kotlinx.android.synthetic.main.createaccount.*
import org.koin.android.ext.android.inject
import androidx.lifecycle.Observer
import com.example.mobileproject4a.presentation.main.MainActivity



class CreateAccountActivity : AppCompatActivity() {

    private val createAccountViewModel : CreateAccountViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createaccount)

        createAccountViewModel.creationLiveData.observe(this, Observer {
            when (it) {
                CreationSuccess -> {
                    MaterialAlertDialogBuilder(this)
                            .setMessage("Account successfully created !")
                            .setTitle("Success")
                            .setPositiveButton("Login") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                    startActivity(Intent(this@CreateAccountActivity, MainActivity::class.java))
                }
                CreationError -> {
                   MaterialAlertDialogBuilder(this)
                            .setMessage("Email address already used")
                            .setTitle("Error")
                            .setPositiveButton("Ok") { dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                }
            }
        })

        submit_button.setOnClickListener {
            createAccountViewModel.onClickedSubmit(
                first_name_edit.text.toString().trim(),
                email_edit.text.toString().trim(),
                password_edit.text.toString().trim()
            )
        }
    }
}