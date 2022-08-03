package com.dungnd.android23.btvn_buoi8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class BtvnBuoi8Adapter(val userList :List<User>) :RecyclerView.Adapter<BtvnBuoi8Adapter.UserVH>() {

    class UserVH(view :View) : RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tvUserName)
        private val tvAddr = view.findViewById<TextView>(R.id.tvUserAddr)
        private val tvPhone = view.findViewById<TextView>(R.id.tvUserPhone)

        fun setData(user:User){
            tvName.text = user.Name
            tvAddr.text = user.Address
            tvPhone.text = user.Phone
        }

    }
    var onClickItem :( (User,Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return UserVH(view)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.setData(userList[position])
        holder.itemView.setOnClickListener{
            onClickItem?.invoke(userList[position],position)
        }

    }

    override fun getItemCount(): Int = if(userList.isNotEmpty()) userList.size else 0


}