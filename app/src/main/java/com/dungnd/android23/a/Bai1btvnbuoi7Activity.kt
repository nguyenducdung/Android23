package com.dungnd.android23.FolderRecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R
import com.dungnd.android23.a.QlAdapter

class bai1btvnbuoi7Activity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var layoutManager: RecyclerView.LayoutManager? = null
    var adapter: RecyclerView.Adapter<QlAdapter.QuanlyVH>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai1btvnbuoi7)

        recyclerView =findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.setHasFixedSize(true)





    }



}