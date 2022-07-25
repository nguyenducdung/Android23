package com.dungnd.android23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BTtrenlopbuoi6Activity : AppCompatActivity() {
    private var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bttrenlopbuoi6)
        recyclerView = findViewById(R.id.recyclerview)
        val linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = linearLayoutManager
        val dividerItemDecoration : DividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView?.addItemDecoration(dividerItemDecoration)
        val array : ArrayList<User> = ArrayList()
        array.add(User(R.drawable.gaquay, "gà quay", "gà quay ngon"))
        array.add(User(R.drawable.suachua, "sữa chua", "sữa chua ngon"))
        array.add(User(R.drawable.sinhtobo, "sinh tố bơ", "sinh tố bơ xay"))
        array.add(User(R.drawable.thitquay, "thịt quay", "thịt quay lạng sơn"))
        array.add(User(R.drawable.trasuadau, "trà sữa dâu", "trà sữa được làm từ dâu"))
        val recyclerviewAdapter : RecyclerviewAdapter = RecyclerviewAdapter(array)
        recyclerView?.adapter = recyclerviewAdapter
        recyclerviewAdapter.onclicklisten = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}