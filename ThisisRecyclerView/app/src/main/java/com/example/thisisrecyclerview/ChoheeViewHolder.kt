package com.example.thisisrecyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChoheeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val tvItem_name : TextView = itemView.findViewById(R.id.tv_ITEM_name)
    val tvItem_description : TextView = itemView.findViewById(R.id.tv_ITEM_description)
    val tvItem_language : TextView = itemView.findViewById(R.id.tv_ITEM_language)

    /** 실제 데이터 연결 */
    fun bind(data : DataDefine){
        tvItem_name.text = data.name
        tvItem_description.text = data.description
        tvItem_language.text = data.language
    }
}




