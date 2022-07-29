package buoi7

import BTVN_buoi6_bai1.Chat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class Buoi7Adapter(val buoi7List: List<Buoi7>) : RecyclerView.Adapter<Buoi7Adapter.Buoi7VH>() {
    class Buoi7VH(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvCmt: TextView = view.findViewById(R.id.tvCmt)

        fun setData(buoi7: Buoi7) {
            tvName.text = buoi7.tvName
            tvCmt.text = buoi7.tvCmt
        }

    }

    var onClickitem: ((Buoi7) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Buoi7VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_buoi7, parent, false)
        return Buoi7VH(view)
    }

    override fun onBindViewHolder(holder: Buoi7VH, position: Int) {
        holder.setData(buoi7List[position])
        holder.itemView.setOnClickListener() {
            onClickitem?.invoke(buoi7List[position])
        }
    }

    override fun getItemCount(): Int = if (buoi7List.isNotEmpty()) buoi7List.size else 0
}