package com.example.thisisretrofit.data

import com.google.gson.annotations.SerializedName

data class GitRepositoryResponseData (
    @SerializedName("name")
    val name : String,
    @SerializedName("int")
    val id: Int
)

//,
//@SerializedName("description")
//val description : String,
////@SerializedName("language")
//val language : String?

