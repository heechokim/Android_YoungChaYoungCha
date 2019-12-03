package com.example.thisisretrofit.server


import com.example.thisisretrofit.data.GitrepositoryItemData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{username}/repos")
    fun getRepoList(@Path("username") username: String): Call<List<GitrepositoryItemData>>
}



