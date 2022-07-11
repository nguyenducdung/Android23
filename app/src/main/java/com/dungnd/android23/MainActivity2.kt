package com.dungnd.android23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var recyclerView : RecyclerView = findViewById(R.id.recyclerview)
        var linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        var array : ArrayList<fileitem> = ArrayList()
        array.add(fileitem("this is file 1"))
        array.add(fileitem("this is file 3"))
        array.add(fileitem("this is file 4"))
        array.add(fileitem("this is file 5"))
        array.add(fileitem("this is file 6"))
        array.add(fileitem("this is file 7"))
        array.add(fileitem("this is file 8"))
        array.add(fileitem("this is file 9"))
        array.add(fileitem("this is file 10"))
        var recyclerViewAdapter : RecyclerViewAdapter = RecyclerViewAdapter(array)
        recyclerView.adapter = recyclerViewAdapter
    }
}