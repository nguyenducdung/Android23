package com.tunanh.bai8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(var context: Context, var array: ArrayList<StudentModel>) :
    RecyclerView.Adapter<StudentAdapter.FolderViewHolder>() {
    //    private var fdList:ArrayList<FolderModel> = ArrayList()
//    private var onClickITem :((FolderModel)-> Unit)?=null
//    fun additem(item:ArrayList<FolderModel>){
//        this.array=item
//        notifyDataSetChanged()
//    }
    var onItemClick: ((StudentModel, Int) -> Unit)? = null

    class FolderViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var name = v.findViewById<TextView>(R.id.name_item)
        private var address = v.findViewById<TextView>(R.id.address_item)
        private var phone = v.findViewById<TextView>(R.id.phone_item)
        fun bindView(studentModel: StudentModel) {
            name.text = studentModel.name
            address.text = studentModel.address
            phone.text = studentModel.phone


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder =
        FolderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_folder, parent, false)
        )

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        val fd = array.get(position)
        holder.bindView(fd)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(array.get(position), position)
        }

//        holder.setOnClickListener{onClickITem?.invoke(fd)}
//        setonClickitem(onClickITem?.invoke(fd),position)
    }

    override fun getItemCount(): Int {
        return array.size
    }
}