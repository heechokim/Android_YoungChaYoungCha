package com.example.thisisretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thisisretrofit.data.GitrepositoryItemData
import com.example.thisisretrofit.server.GithubServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GitrepositoryActivity : AppCompatActivity() {

    private lateinit var rv_main: RecyclerView
    private lateinit var rv_Adapter: GitrepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gitrepository)

        initRepositoryRecyclerView()
    }

    private fun initRepositoryRecyclerView(){
        rv_main = findViewById(R.id.rv_gitrepository)
        rv_Adapter = GitrepositoryAdapter(this)
        rv_main.adapter = rv_Adapter
        rv_main.layoutManager = LinearLayoutManager(this)

        /** repository list를 서버에서 받아오기 위한 Callback요청 */
        val call: Call<List<GitrepositoryItemData>> = GithubServiceImpl.service.getRepoList("choheeis")
        call.enqueue(
            object : Callback<List<GitrepositoryItemData>>{
                // 서버 통신에 실패했을 때 Retrofit이 onFailure를 호출한다.
                override fun onFailure(call: Call<List<GitrepositoryItemData>>, t: Throwable) {
                    Log.e("server_test", "fail")
                }

                // 서버 통신에 성공했을 때 Retrofit이 onResponse를 호출한다.
                // 이 함수 내부에 있는 response에 서버에서 받아온 데이터가 들어있다.
                override fun onResponse(
                    call: Call<List<GitrepositoryItemData>>,
                    response: Response<List<GitrepositoryItemData>>
                ) {
                    if(response.isSuccessful){
                        val gitRepos: List<GitrepositoryItemData> = response.body()!!
                        rv_Adapter.data = gitRepos
                        rv_Adapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }
}
