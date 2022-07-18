package com.dungnd.android23.buoi5

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dungnd.android23.R

class KotlinActivity : AppCompatActivity(), OnClick, View.OnClickListener {

    val count: Int = 0

    //Biến var có gán giá trị mặc định
    var count1: Int = 0

    //Biến var k gán giá trị mặc định
    var count2: Int? = null

    //K khai báo kiểu dữ liệu
    var count3 = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        tinhTong(10, 2)
        tinhHieu(3)

        val student = StudentKotlin(1)
        val student3 = StudentKotlin(1, "abc")
        //Set dữ liệu
        student.name = "Nguyễn Đức Dũng"
        student.age = 30
        student.high = 100

        //Set dữ liệu kiểu 2
        val student2 = StudentKotlin(10).apply {
            this.name = "ấdfasfdasdf"
            this.age = 10
        }

        //Get dữ liệu
        Toast
            .makeText(this,
                student.name + student.age,
                Toast.LENGTH_LONG)
            .show()

        if (student.age > 10) {
            //todo
        } else {

        }

        //duyệt vòng for từ 1 đến 10
        for (i in 1..10) {

        }

        val students = ArrayList<StudentData>()
        students.add(StudentData("11", "10"))

        val studentList = mutableListOf<StudentData>()
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))
        studentList.add(StudentData("11", "10"))

        for (i in 0..studentList.size) {

        }
        for (stu in studentList) {

        }

        //Hàm mở rộng của List (extension), it chính là 1 phần tử trong list
        studentList.forEach {
            it.name
        }
        //Duyệt vòng for có trả kèm vị trí của từng phần tư
        studentList.forEachIndexed { index, studentData ->

        }

        //Một số hàm khác
        //Hàm lọc với bộ lọc là nam == "abc" thì trả về 1 list các dữ liệu
        studentList.filter { it.name == "abc" }

        //Trả về phần tử đầu tiên có tên == "abc", nếu k có thì trả về null
        studentList.firstOrNull { it.name == "abc" }

    }

    private fun logLinhtinh(result: String, result2: String) {

    }

    private fun tinhTong(a: Int, b: Int): Int {
        return a.times(b)
    }

    //Trong trường hợp không truyền giá trị của b
    //thì giá trị của b mặc định là 1
    //Trong trường hợp có dấu ? nghĩa là giá trị của biến
    //đó có thể là null
    private fun tinhHieu(a: Int?, b: Int = 1): Int? {
        return a?.div(b)
    }

    private fun tinhTong2(a: Int, b: Int) = a+b
    override fun clicked() {

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    //Các cách viết kiểu when
    private fun vietWhen() {
        //đối tượng k đổi, chỉ có giá trị bên trong thay đổi nên để đối tượng là val
        val student = StudentKotlin(10)

        //Cách 1
        when {
            student.age == 1 && student.name == "a" -> {
                Log.d("àasfasdfasd", "ádfsđfsdf")
            }
            student.age == 1 -> {

            }
            student.age == 2 -> {

            }
            else -> {

            }
        }

        //Cách 2
        when (student.age) {
            1 -> {

            }
            2 -> {

            }
            else -> {

            }
        }

        if (student.age == 1 && student.name == "a") {
            Log.d("àasfasdfasd", "ádffsdf")
        } else if (student.age == 2) {
            Log.d("àasfasdfasd", "ádfssdf")
        } else {
            Log.d("àasfasdfasd", "ádfsđdf")
        }
    }

    //$ten_bien (cộng chuỗi string)
    //${nhân, chia, ..., 1 hàm bất kỳ} (khi thực hiện xong phần trong {}
    //sẽ mới thực hiện cộng chuỗi
    private fun xuLyChuoi() {
        val a = "abc"
        val b = "bcd"
        val c = "$a$b" //Kết quả sẽ là "abcbcd"
        val d = 100 * 10
        val e = a + d //Kết quả "abc1000"
        val f = "$a${100*10}${199-10} Tôi tên là: ${getTen()}" //Kết quả "abc1000"
        val g = "abc"
        //Áp dụng cho string và list (array list)
        g.isNotEmpty() //biến g có thể rỗng hay không: false - đang rỗng
        g.isEmpty() // biến g có thể rỗng hay không: true - đang rỗng
        g.isNullOrEmpty() // biến g có thể null hoặc rỗng hay k: true - null hoặc rỗng

    }

    private fun getTen() : String {
        return "Dũng"
    }
}