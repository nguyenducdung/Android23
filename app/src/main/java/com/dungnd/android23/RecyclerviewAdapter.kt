package com.dungnd.android23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(var array : ArrayList<User>) : RecyclerView.Adapter<RecyclerviewAdapter.Itemholder>() {
    class Itemholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var avt : ImageView = itemView.findViewById(R.id.img_avt)
        var title : TextView = itemView.findViewById(R.id.tv_title)
        var content : TextView = itemView.findViewById(R.id.tv_content)
        fun setData(user: User){
            avt.setImageResource(user.avt)
            title.text = user.title
            content.text = user.content
        }
    }
    var onclicklisten : ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Itemholder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return Itemholder(view)
    }

    override fun onBindViewHolder(holder: Itemholder, position: Int) {
        val user : User = array.get(position)
        holder.setData(user)
        holder.title.setOnClickListener {
            onclicklisten?.invoke(user.title)
        }
        holder.content.setOnClickListener {
            onclicklisten?.invoke(user.content)
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