package com.example.thisisretrofit.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubServiceImpl {

    private const val BASE_URL = "https://api.github.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // GithubService는 Request 메소드들을 작성해놓은 인터페이스.
    val service: GithubService = retrofit.create(GithubService::class.java)

}





