package com.dungnd.android23.buoi6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.recycleview.Student

class StudentKotlinAdapter(val studentList: List<Student>): RecyclerView.Adapter<StudentKotlinAdapter.StudentVH>() {
    class StudentVH(view: View): RecyclerView.ViewHolder(view) {
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvAge = view.findViewById<TextView>(R.id.tvAge)

        fun setData(student: Student) {
            tvName.text = student.name
            tvAge.text = "${student.age} tuổi"
        }
    }

    var onClickItem: ((Student) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentVH(view)
    }

    override fun onBindViewHolder(holder: StudentVH, position: Int) {
        holder.setData(studentList[position])
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(studentList[position])
        }
    }

    override fun getItemCount(): Int = if (studentList.isNotEmpty()) studentList.size else 0
}