package com.example.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list : List<Contact>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_view, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.listView.text = list[position]
        holder.names.text = list[position].name
        holder.mobile.text = list[position].mobile.toString()
        holder.address.text = list[position].address
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var names = itemView.findViewById<TextView>(R.id.name)
        var mobile = itemView.findViewById<TextView>(R.id.mobile)
        var address = itemView.findViewById<TextView>(R.id.address)
    }

}


