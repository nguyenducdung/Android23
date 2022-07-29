package com.dungnd.android23.buoi7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.recycleview.Student
import org.w3c.dom.Text

class Buoi7RecycleviewAdapter(val folderList: List<Folder>) :RecyclerView.Adapter<Buoi7RecycleviewAdapter.folderVH>() {
    class folderVH(view: View):RecyclerView.ViewHolder(view){
        private val tvFolderTitle= view.findViewById<TextView>(R.id.tvFolderTitle)
        private val tvFolderNotice= view.findViewById<TextView>(R.id.tvFolderNotice)

        fun setData(folder:Folder){
            tvFolderTitle.text = folder.title
            tvFolderNotice.text =folder.content
        }

    }
    var onClickItem: ((Folder) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): folderVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_folder,parent,false)
        return folderVH(view)
    }

    override fun onBindViewHolder(holder: folderVH, position: Int) {
        holder.setData(folderList[position])
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(folderList[position])
        }
    }

    override fun getItemCount(): Int = if(folderList.isNotEmpty()) folderList.size else 0
}