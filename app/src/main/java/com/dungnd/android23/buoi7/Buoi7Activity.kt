package com.dungnd.android23.buoi7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.dungnd.android23.R
import com.dungnd.android23.buoi8.setOnSingleClick
import com.dungnd.android23.buoi8.toastLinhTinh

class Buoi7Activity : AppCompatActivity() {
    private var flFragment1: FrameLayout? = null
    private var flFragment2: FrameLayout? = null
    private var btnOpen: Button? = null
    var so = ""

    //Truyền ngược từ màn Buoi7Hai Về màn Buoi7
    //Dùng khi cần gọi đến các thứ mặc định trong máy(ví dụ: chọn ảnh, chụp ảnh, ....)
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val so = result.data?.extras?.getInt("key4")
                Toast.makeText(this, "$so", Toast.LENGTH_SHORT).show()
            }
        }


    //Khởi tạo, findViewById, chỉ được gọi 1 lần (call api)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7)
        flFragment1 = findViewById(R.id.flFragment1)
        btnOpen = findViewById(R.id.btnOpen)
//        flFragment2 = findViewById(R.id.flFragment2)
        openManMoi()
        val fragment1 = Buoi7Fragment.newFragment("Đây là data")
//        val fragment2 = Buoi7HaiFragment()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.flFragment1, fragment1, fragment1.tag)
            .commitAllowingStateLoss()
//        fragmentTransaction.add(R.id.flFragment2, fragment2, fragment2.tag)
//            .commitAllowingStateLoss()
    }

    //Đc gọi nhiều lần
    override fun onStart() {
        super.onStart()
    }

    //Sau hàm onResume, chúng ta có thể thấy màn hình
    //ĐƯợc gọi nhiều lần, chúng ta có xử lý một số logic cần khi app quay trở lại foreground
    override fun onResume() {
        super.onResume()
    }

    //Khi app được xuống background (các bạn cần lưu lại 1 số dữ liệu gì đó để
    //khi app từ background lên foreground nó hiển thị luôn
    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    //Huỷ activity (hệ thống android kill app, chúng ta gọi)
    //remove, clear một số observe, 1 số luồng call api dang dở, 1 số sự kiện...
    //Tiết kiệm bộ nhớ, tránh bị leak memory
    override fun onDestroy() {
        super.onDestroy()
    }

    fun toastLinhTinh(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun openManMoi() {
        btnOpen?.setOnSingleClick {

        }
        btnOpen?.toastLinhTinh()
        btnOpen?.setOnClickListener {
            val intent = Intent(this, Buoi7BarActivity::class.java)
            //truyền dữ liệu kiểu int
            intent.putExtra("key1", 10)
            //truyền dữ liệu kiểu string
            intent.putExtra("key2", "Tôi tên là Dũng")
            val data = SeventData().apply {
                this.title = "Đây là title"
                this.content = "Đây là content"
            }
            intent.putExtra("key3", data)
//            startActivity(intent)
            startForResult.launch(intent)
        }
    }
}