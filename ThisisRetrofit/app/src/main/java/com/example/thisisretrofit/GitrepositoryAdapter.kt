package com.example.thisisretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thisisretrofit.data.GitrepositoryItemData


class GitrepositoryAdapter(private val context: Context) : RecyclerView.Adapter<GitrepositoryViewHolder>(){

    var data = listOf<GitrepositoryItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitrepositoryViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_gitrepository, parent, false)
        return GitrepositoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GitrepositoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

