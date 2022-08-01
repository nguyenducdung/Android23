package com.dungnd.android23.chuabtnv8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.buoi8.AppRoomDatabase

class Man1Activity : AppCompatActivity() {
    private var linearLayout : LinearLayout? = null
    private var recyclerView : RecyclerView? = null
    private var array : ArrayList<User> = ArrayList()
    private var userDao: UserDao? = null
    private var recyclerviewAdappter: RecyclerviewAdappter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_man1)
        linearLayout = findViewById(R.id.linearlayout)
        recyclerView = findViewById(R.id.recyclerview)
        userDao = AppRoomDatabase.getDatabase(this).userDao()
        array = (userDao?.getAllUser() as? ArrayList<User>) ?: ArrayList()

        recyclerviewAdappter = RecyclerviewAdappter(array)
        recyclerView?.adapter = recyclerviewAdappter

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val name : String? = result.data?.extras?.getString("name")
                    val address : String? = result.data?.extras?.getString("address")
                    val phone : String? = result.data?.extras?.getString("phone")
                    val user = User(
                        id = System.currentTimeMillis(),
                        name = name ?: "",
                        address = address ?: "",
                        phone = phone ?:""
                    )
                    userDao?.insert(user)
                    updateData()
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
                recyclerviewAdappter?.notifyDataSetChanged()
            }
        }
        recyclerviewAdappter?.onclick = {
            val intent = Intent(this, Man3Activity::class.java)
            intent.putExtra("data", it)
            startForResult1.launch(intent)
        }
        recyclerviewAdappter?.onremove = {
            array.removeAt(it)
            recyclerviewAdappter?.notifyDataSetChanged()
        }
    }

    private fun updateData() {
        array = userDao?.getAllUser() as ArrayList<User>
        recyclerviewAdappter?.setArrayList(array)
        recyclerviewAdappter?.notifyDataSetChanged()
    }
}