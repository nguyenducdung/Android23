package btvn_buoi8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class SinhVienActivity : AppCompatActivity() {
    companion object {
        const val KEY = "KEY"
        const val TYPE_EDIT = "TYPE_EDIT "
        const val TYPE_ADD = "TYPE_ADD"

    }

    private lateinit var rcvData: RecyclerView
    private lateinit var tvAdd: TextView
    private val listSinhVien: MutableList<SinhVien> = ArrayList()
    private lateinit var reyclerviewAdapter: SinhVienAdapter
    private var vRemove: ImageView? = null
    private val startForResult1 =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val type = result.data?.extras?.getString(KEY)
                if (type == TYPE_ADD) {
                    val buoi8item = result.data?.extras?.get("SinhVien") as? SinhVien
                    if (buoi8item != null) {
                        listSinhVien.add(buoi8item)
                    }
                    reyclerviewAdapter?.notifyDataSetChanged()
                } else if (type == TYPE_EDIT) {
                    val sinhVien = result.data?.extras?.get("SinhVien") as? SinhVien
                    if (sinhVien != null) {
                        for (item in listSinhVien) {
                            if (item.id == sinhVien.id) {
                                item.tvName = sinhVien.tvName
                                item.tvAdress = sinhVien.tvAdress
                                item.tvPhone = sinhVien.tvPhone
                                break
                            }
                        }
                        reyclerviewAdapter?.notifyDataSetChanged()
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_sinhvien)
        rcvData = findViewById(R.id.rcvData)
        tvAdd = findViewById(R.id.tvAdd)
        vRemove = findViewById(R.id.vRemove)
        addData()
        setOnClickAdd()
        reyclerviewAdapter = SinhVienAdapter(listSinhVien)
        rcvData?.adapter = reyclerviewAdapter
        rcvData?.layoutManager = LinearLayoutManager(this)
        reyclerviewAdapter.onClickitem = { sinhVien, position ->
            val intent = Intent(this, SinhVienEdit::class.java)
            intent.putExtra("SinhVien", sinhVien)
            startForResult1.launch(intent)
        }
        reyclerviewAdapter.onClickremove = {
            listSinhVien.removeAt(it)
            reyclerviewAdapter.notifyDataSetChanged()
        }

    }

    private fun addData() {
        val sinhVienItem1 = SinhVien().apply {
            this.id = 1
            this.tvName = "Tên:Võ Hữu Thịnh1"
            this.tvAdress = "Địa chỉ: Triều khúc, Thanh Xuân, Hà Nội"
            this.tvPhone = "Phone: 0962890153"
        }
        val sinhVienItem2 = SinhVien().apply {
            this.id = 2
            this.tvName = "vvvv"
            this.tvAdress = "Địa chỉ: Triều khúc, Thanh Xuân, Hà Nội"
            this.tvPhone = "Phone: 0962890153"
        }
        val sinhVienItem3 = SinhVien().apply {
            this.id = 3
            this.tvName = "abbbbb"
            this.tvAdress = "Địa chỉ: Triều khúc, Thanh Xuân, Hà Nội"
            this.tvPhone = "Phone: 0962890153"
        }


        listSinhVien.add(sinhVienItem1)
        listSinhVien.add(sinhVienItem2)
        listSinhVien.add(sinhVienItem3)
    }

    private fun setOnClickAdd() {
        tvAdd.setOnClickListener {
            val intent: Intent = Intent(this@SinhVienActivity, SinhVienAdd::class.java)
            startForResult1.launch(intent)
        }
    }


}