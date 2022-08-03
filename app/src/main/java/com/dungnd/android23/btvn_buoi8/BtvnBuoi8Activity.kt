package com.dungnd.android23.btvn_buoi8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.buoi7.Buoi7BarActivity
import com.dungnd.android23.buoi7.SeventData
import com.dungnd.android23.recycleview.Student

class BtvnBuoi8Activity : AppCompatActivity() {

    private var imgAddUser : ImageView? = null
    private var rcvData: RecyclerView?=null
    private var adapter :BtvnBuoi8Adapter?=null
    private var array : ArrayList<User> = ArrayList()

    private val startForResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){

            val type = result?.data?.extras?.getString("Man1")

            if(type == "TYPE_ADD"){
                val user = result.data?.extras?.get("user") as? User
                if(user != null){
                    array.add(user)
                    adapter?.notifyDataSetChanged()
                }

            }else if(type =="TYPE_UPDATE"){
                val user = result.data?.extras?.get("user") as? User
                if(user != null){
                    for(x in array){
                        if(x.id == user.id){
                            x.Name = user.Name
                            x.Address = user.Address
                            x.Phone= user.Phone
                            break
                        }
                    }
                    adapter?.notifyDataSetChanged()
                }
            }
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvn_buoi8)
        ///////
        rcvData = findViewById<RecyclerView>(R.id.rcvData)
        imgAddUser = findViewById<ImageView>(R.id.imgAdd)
        array = createUserList()
        adapter = BtvnBuoi8Adapter(array)
        rcvData?.adapter = adapter
        //////
        adapter?.onClickItem= { user, position  ->
            openUpdateUser(user,position)
        }
        ///////////
        imgAddUser?.setOnClickListener(){
            openAddUser()
        }


    }

    private fun createUserList(): ArrayList<User> {
        val userList : ArrayList<User> = ArrayList()

        userList.add(User(1,"Vo Huu Thinh","Thanh Xuan Trieu Khuc","0123456789"))
        userList.add(User(2,"Vo Huu Thinh","Thanh Xuan Trieu Khuc","0123456789"))
        userList.add(User(3,"Vo Huu Thinh","Thanh Xuan Trieu Khuc","0123456789"))
        userList.add(User(4,"Vo Huu Thinh","Thanh Xuan Trieu Khuc","0123456789"))
        userList.add(User(5,"Vo Huu Thinh","Thanh Xuan Trieu Khuc","0123456789"))
        userList.add(User(6,"Vo Huu Thinh","Thanh Xuan Trieu Khuc","0123456789"))
        return userList
    }
    private fun openAddUser() {
            val intent = Intent(this, BtvnBuoi8OneActivity::class.java)
            startForResult.launch(intent)
    }
    private fun openUpdateUser(user:User,position:Int){
        val intent = Intent(this, BtvnBuoi8HightActivity::class.java)
        intent.putExtra("user",user)
        startForResult.launch(intent)
    }
}