/*
 * *
 *  * MIT License
 *  * Copyright (c) 2021 Antoine Mairet
 *  * Last modified 01/01/21 20:37
 *
 */

package com.example.mobileproject4a.presentation.list


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileproject4a.R
import com.example.mobileproject4a.domain.entity.Movie
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.list.*
import org.koin.android.ext.android.inject

class ListActivity : AppCompatActivity() {

    private val listViewModel : ListViewModel by inject()
    private lateinit var movieAdapter : ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)
        listViewModel.makeApiCall()

        listViewModel.APIMovieCallLiveData.observe(this, {
            when(it){
                is APICallSuccess -> {
                    initRecyclerView()
                    addDataSet(it.movieList)
                }
                APICallError -> {
                    MaterialAlertDialogBuilder(this).setTitle("Error").setMessage("API Call Error").setPositiveButton("Ok"){ dialog,
                                                                                                                                              _ -> dialog.dismiss()}.show()
                }
            }
        })
    }
    private fun addDataSet(movieList: List<Movie>){
        movieAdapter.submitList(movieList)
    }

    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            movieAdapter = ListAdapter()
            recyclerView.adapter = movieAdapter
        }
    }


}