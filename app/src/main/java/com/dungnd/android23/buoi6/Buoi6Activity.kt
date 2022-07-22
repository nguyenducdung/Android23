package com.dungnd.android23.buoi6

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.recycleview.Student
import java.util.*
import kotlin.collections.ArrayList

class Buoi6Activity : AppCompatActivity() {

    //Lamda function
    //((Kiểu dữ liệu) -> Unit
    //Kiểu dữ liệu có thể có hoặc không
    private var print: (() -> Unit) = {
        Toast.makeText(this, "HIHI", Toast.LENGTH_SHORT).show()
    }

    private var print2: ((String) -> Unit) = {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi6)
        tinhTong(1, 2)
        print2.invoke("Tôi là dũng")

        val rcvData = findViewById<RecyclerView>(R.id.rcvData)
        val tvName = findViewById<TextView>(R.id.tvName)
        val adapter = StudentKotlinAdapter(createStudentList())
        adapter.onClickItem = { student ->
            goiApiTinhABC {
//                Toast.makeText(this, "${student.name}_${student.age}_$it", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "${student.getData()}", Toast.LENGTH_SHORT).show()
            }
            tvName.showName()
        }
        rcvData.adapter = adapter

        Database.suaDuLieu()
//        if (student != null) {
//            //todo
//        }
        student?.let {
            //todo it
            print(it.name)
        }

        val chat = Chat().apply {
            this.image = R.drawable.ic_food
            this.title = "Nguyen Duc Dung"
            this.content = "Ancsfasdfasf"
        }
    }

    private fun goiApiTinhABC(callback: ((String) -> Unit)) {
        //Gọi api
        //Tinh toan linh tinh gì đó
        tinhTong(1, 2)
        giaiPhuongTrinh()
        //Sau khi làm xong mọi việc thì báo là đã xong việc
        callback.invoke("Thành công")
    }

    private fun createStudentList(): List<Student> {
        val studentList: MutableList<Student> = ArrayList()
        val studentItem = Student().apply {
            this.name = "Dương 0"
            this.age = 100
        }

        studentList.add(studentItem)
        studentList.add(Student("Dương", 20, "1", "Bắc Ninh"))
        studentList.add(Student("Dương1", 21, "1", "Bắc Ninh"))
        studentList.add(Student("Dương2", 22, "1", "Bắc Ninh"))
        studentList.add(Student("Dương3", 23, "1", "Bắc Ninh"))
        studentList.add(Student("Dương4", 24, "1", "Bắc Ninh"))
        studentList.add(Student("Dương5", 25, "1", "Bắc Ninh"))
        studentList.add(Student("Dương6", 26, "1", "Bắc Ninh"))
        studentList.add(Student("Dương7", 27, "1", "Bắc Ninh"))
        studentList.add(Student("Dương8", 28, "1", "Bắc Ninh"))
        studentList.add(Student("Dương9", 29, "1", "Bắc Ninh"))
        studentList.add(Student("Dương10", 30, "1", "Bắc Ninh"))
        studentList.add(Student("Dương11", 31, "1", "Bắc Ninh"))
        studentList.add(Student("Dương12", 22, "1", "Bắc Ninh"))
        studentList.add(Student("Dương13", 22, "1", "Bắc Ninh"))
        studentList.add(Student("Dương14", 20, "1", "Bắc Ninh"))
        studentList.add(Student("Dương15", 20, "1", "Bắc Ninh"))
        studentList.add(Student("Dương16", 20, "1", "Bắc Ninh"))
        studentList.add(Student("Dương17", 20, "1", "Bắc Ninh"))
        studentList.add(Student("Dương18", 20, "1", "Bắc Ninh"))
        studentList.add(Student("Dương19", 20, "1", "Bắc Ninh"))
        return studentList
    }

}

object Database {
    fun xoaDuLieu() {

    }

    fun suaDuLieu() {

    }
}