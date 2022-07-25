package com.dungnd.android23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BTVNbuoi6Activity : AppCompatActivity() {
    var recyclerView : RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btvnbuoi6)
        recyclerView = findViewById(R.id.recyclerview_dogs)
        val gridLayoutManager : GridLayoutManager = GridLayoutManager(this, 3)
        recyclerView?.layoutManager = gridLayoutManager
        val array : ArrayList<Dogs> = ArrayList()
        array.add(Dogs(R.drawable.cho1))
        array.add(Dogs(R.drawable.cho2))
        array.add(Dogs(R.drawable.cho3))
        array.add(Dogs(R.drawable.cho4))
        array.add(Dogs(R.drawable.cho5))
        array.add(Dogs(R.drawable.cho6))
        array.add(Dogs(R.drawable.cho7))
        array.add(Dogs(R.drawable.cho8))
        array.add(Dogs(R.drawable.cho9))
        array.add(Dogs(R.drawable.cho10))
        array.add(Dogs(R.drawable.cho11))
        array.add(Dogs(R.drawable.cho12))
        val recyclerviewAdapter : RecyclerviewAdapter = RecyclerviewAdapter(array)
        recyclerView?.adapter = recyclerviewAdapter
        recyclerviewAdapter.onclick = {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}