package com.example.tuananh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FolderAdapter : RecyclerView.Adapter<FolderAdapter.FolderViewHolder>() {
    private var fdList:ArrayList<FolderModel> = ArrayList()
//    private var onClickITem :((FolderModel)-> Unit)?=null
    fun additem(item:ArrayList<FolderModel>){
        this.fdList=item
        notifyDataSetChanged()
    }
    var onItemClick: ((FolderModel, Int) -> Unit)? = null
    class FolderViewHolder(v:View):RecyclerView.ViewHolder(v){
        private var title=v.findViewById<TextView>(R.id.title_item)
        private var content=v.findViewById<TextView>(R.id.content_item)
        fun bindView(folderModel: FolderModel){
            title.text=folderModel.title
            content.text=folderModel.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder = FolderViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_folder,parent,false))

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        val fd=fdList[position]
        holder.bindView(fd)
        onItemClick?.invoke(fdList.get(position), position)
//        holder.setOnClickListener{onClickITem?.invoke(fd)}
//        setonClickitem(onClickITem?.invoke(fd),position)
    }

    override fun getItemCount(): Int {
        return fdList.size
    }
}