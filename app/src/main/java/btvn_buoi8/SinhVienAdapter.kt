package btvn_buoi8

import BTVN_buoi6_bai1.Chat
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import kotlin.coroutines.coroutineContext

class SinhVienAdapter(val listSinhVien: List<SinhVien>) : RecyclerView.Adapter<SinhVienAdapter.SinhVienVH>() {
    class SinhVienVH(view: View) : RecyclerView.ViewHolder(view){
        val tvName : TextView = view.findViewById(R.id.tvName)
        val tvAdress : TextView = view.findViewById(R.id.tvAdress)
        val tvPhone : TextView = view.findViewById(R.id.tvPhone)
        var vRemove : ImageView = itemView.findViewById(R.id.vRemove)
        fun setData(sinhvien : SinhVien){
            tvName.text = sinhvien.tvName
            tvAdress.text = sinhvien.tvAdress
            tvPhone.text = sinhvien.tvPhone

        }
    }
    var onClickitem: ((SinhVien, Int) -> Unit)? = null
    var onClickremove: (( Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SinhVienVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sinh_vien,parent,false)
        return SinhVienVH(view)
    }

    override fun onBindViewHolder(holder: SinhVienVH, position: Int) {
        holder.setData(listSinhVien[position])
        holder.itemView.setOnClickListener(){
            onClickitem?.invoke(listSinhVien[position],position)
        }
        holder.vRemove.setOnClickListener(){
            onClickremove?.invoke(position)
        }


    }

    override fun getItemCount(): Int = if (listSinhVien.isNotEmpty()) listSinhVien.size else 0
}