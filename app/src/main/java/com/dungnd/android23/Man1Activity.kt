package com.dungnd.android23

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Man1Activity : AppCompatActivity() {
    private var linearLayout : LinearLayout? = null
    private var recyclerView : RecyclerView? = null
    private var array : ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man1)
        linearLayout = findViewById(R.id.linearlayout)
        recyclerView = findViewById(R.id.recyclerview)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = linearLayoutManager
        array.add(User(1,"Võ Hữu Thịnh", "Triều Khúc, Thanh Xuân, Hà Nội", "0962890153"))
        array.add(User(2,"Võ Hữu Thịnh", "Triều Khúc, Thanh Xuân, Hà Nội", "0962890153"))
        array.add(User(3,"Võ Hữu Thịnh", "Triều Khúc, Thanh Xuân, Hà Nội", "0962890153"))
        array.add(User(4,"Võ Hữu Thịnh", "Triều Khúc, Thanh Xuân, Hà Nội", "0962890153"))
        val recyclerviewAdappter = RecyclerviewAdappter(array)
        recyclerView?.adapter = recyclerviewAdappter
        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val name : String? = result.data?.extras?.getString("name")
                    val address : String? = result.data?.extras?.getString("address")
                    val phone : String? = result.data?.extras?.getString("phone")
                    array.add(User(5, name.toString(), address.toString(), phone.toString()))
                    recyclerviewAdappter.notifyDataSetChanged()
                }
            }
        linearLayout?.setOnClickListener {
            val intent = Intent(this, Man2Activity::class.java)
            startForResult.launch(intent)
        }
        val startForResult1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val user : User = result.data?.extras?.get("dulieu") as User
                for(item in array){
                    if(item.id == user.id){
                        item.name = user.name
                        item.address = user.address
                        item.phone = user.phone
                        break
                    }
                }
                recyclerviewAdappter.notifyDataSetChanged()
            }
        }
        recyclerviewAdappter.onclick = {
            val intent = Intent(this, Man3Activity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("user", it)
            intent.putExtra("data", bundle)
            startForResult1.launch(intent)
        }
        recyclerviewAdappter.onremove = {
            array.removeAt(it)
            recyclerviewAdappter.notifyDataSetChanged()
        }
    }
}