package com.example.passkeep

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passkeep.CardInfo
import com.example.passkeep.R
import com.example.passkeep.UpdateCard
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var website = itemView.tvWebsite_view
        var email = itemView.tvEmail_view
        var password = itemView.tvPassword_view
        var layout = itemView.mylayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
 /*       val colours = arrayListOf<String>("#FF5722", "#FFC107", "#8BC34A")
        val randomGen = colours.random()
        holder.layout.setBackgroundColor(Color.parseColor("$randomGen"))*/
        holder.website.text = "Website: " + data[position].website
        holder.email.text = "Username: " + data[position].email
        holder.password.text = "Password: " + data[position].password
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context, UpdateCard::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}