package com.dungnd.android23.chuabtnv8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class RecyclerviewAdappter(var array : ArrayList<User>) : RecyclerView.Adapter<RecyclerviewAdappter.Itemholder>() {
    class Itemholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvname : TextView = itemView.findViewById(R.id.username)
        var tvaddress : TextView = itemView.findViewById(R.id.useraddress)
        var tvphone : TextView = itemView.findViewById(R.id.userphone)
        var imgremove : ImageView = itemView.findViewById(R.id.img_remove)
    }

    fun setArrayList(array : ArrayList<User>) {
        this.array = array
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemholder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return Itemholder(view)
    }
    var onclick : ((User) -> Unit)? = null
    var onremove : ((Int) -> Unit)? = null
    override fun onBindViewHolder(holder: Itemholder, position: Int) {
        val user = array.get(position)
        holder.tvname.text = user.name
        holder.tvaddress.text = user.address
        holder.tvphone.text = user.phone
        holder.itemView.setOnClickListener {
            onclick?.invoke(user)
        }
        holder.imgremove.setOnClickListener {
            onremove?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}