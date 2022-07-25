package com.dungnd.android23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(var array : ArrayList<Dogs>) : RecyclerView.Adapter<RecyclerviewAdapter.Itemholder>() {
    class Itemholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var img_avt : ImageView = itemView.findViewById(R.id.img_avt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemholder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return Itemholder(view)
    }
    var onclick : ((String) -> Unit)? = null
    override fun onBindViewHolder(holder: Itemholder, position: Int) {
        val dogs : Dogs = array.get(position)
        holder.img_avt.setImageResource(dogs.avt)
        holder.itemView.setOnClickListener {
            onclick?.invoke("bạn đã click chọn")
        }
    }

    override fun getItemCount(): Int {
        if(array != null){
            return array.size
        }else{
            return 0
        }
    }
}