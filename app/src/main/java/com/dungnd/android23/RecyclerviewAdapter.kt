package com.dungnd.android23

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(var context : Context, var array : ArrayList<Folder>) : RecyclerView.Adapter<RecyclerviewAdapter.Itemholder>() {
    class Itemholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvtitle : TextView = itemView.findViewById(R.id.tv_title)
        var tvcontent : TextView = itemView.findViewById(R.id.tv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemholder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return Itemholder(view)
    }
    override fun onBindViewHolder(holder: Itemholder, position: Int) {
        val person = array.get(position)
        holder.tvtitle.text = person.title
        holder.tvcontent.text = person.content
        holder.itemView.setOnClickListener {
            val title : String = holder.tvtitle.text.toString()
            val content : String = holder.tvcontent.text.toString()
            val intent : Intent = Intent(context, Man2Activity::class.java)
            intent.putExtra("datatitle", title)
            intent.putExtra("datacontent", content)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}