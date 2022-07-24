package BTVN_buoi6_bai1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class ChatAdapter(val chatList: List<Chat>, val context: Context) : RecyclerView.Adapter<ChatAdapter.ChatVH>() {
    class ChatVH(view: View) : RecyclerView.ViewHolder(view) {
        val vImage: ImageView = view.findViewById(R.id.vImage)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvCmt: TextView = view.findViewById(R.id.tvCmt)

        fun setData(chat: Chat, context: Context) {
            tvName.text = chat.tvName
            tvCmt.text = chat.tvCmt
            vImage.setImageDrawable(chat.vImage?.let(context::getDrawable))
        }

    }

    var onClickitem: ((Chat) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatVH(view)
    }

    override fun onBindViewHolder(holder: ChatVH, position: Int) {
        val currentItem = chatList[position]
        holder.setData(currentItem, context)
        holder.itemView.setOnClickListener {
            onClickitem?.invoke(chatList[position])
        }
    }


    override fun getItemCount(): Int = if (chatList.isNotEmpty()) chatList.size else 0
}