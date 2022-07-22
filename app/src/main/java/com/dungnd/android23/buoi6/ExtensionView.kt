package com.dungnd.android23.buoi6

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.dungnd.android23.R
import com.dungnd.android23.buoi5.StudentKotlin
import com.dungnd.android23.recycleview.Student

//Trong extension các bạn đc sử dụng tất cả các hàm, thuộc tính
//của đối tượng mà extension hướng đến
fun TextView.showName() {
    text = "Nguyễn Đức Dũng"
    setTextColor(ContextCompat.getColor(context, R.color.black))
}

fun Student.getData(): String {
    return "$name$age "
}