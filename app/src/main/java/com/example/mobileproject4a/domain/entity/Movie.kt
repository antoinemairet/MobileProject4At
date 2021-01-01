package com.example.mobileproject4a.domain.entity


data class Movie (
        var id:String,
        var rank:Int,
        var rankUpDown:Int,
        var title:String,
        var fullTitle:String,
        var year:Int,
        var image:String,
        var crew:String,
        var imDbRating:Int,
        var imDbRatingCount:Int
        )