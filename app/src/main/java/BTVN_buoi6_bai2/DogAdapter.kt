package BTVN_buoi6_bai2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class DogAdapter(val dogList: List<Dog>, val context: Context) : RecyclerView.Adapter<DogAdapter.dogVH>() {
    class dogVH(view: View) : RecyclerView.ViewHolder(view) {
        val vImage: ImageView = view.findViewById(R.id.vImage)


        fun setData(dog: Dog, context: Context) {
            vImage.setImageDrawable(dog.vImage?.let(context::getDrawable))

        }
    }

    var onClickitem: ((Dog) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dogVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return dogVH(view)
    }

    override fun onBindViewHolder(holder: dogVH, position: Int) {
        holder.setData(dogList[position], context)
        holder.itemView.setOnClickListener {
            onClickitem?.invoke(dogList[position])
        }
    }


    override fun getItemCount(): Int = if (dogList.isNotEmpty()) dogList.size else 0
}