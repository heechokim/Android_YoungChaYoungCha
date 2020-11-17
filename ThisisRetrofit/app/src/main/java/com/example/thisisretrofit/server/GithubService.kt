package com.example.thisisretrofit.server

import com.example.thisisretrofit.data.GitRepositoryResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/orgs/{org}/repos")
    fun getRepoList(@Path("org") username: String): Call<List<GitRepositoryResponseData>>
}




