package com.example.thisisrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context) : RecyclerView.Adapter<ChoheeViewHolder>(){

    var data = listOf<DataDefine>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoheeViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ChoheeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChoheeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

