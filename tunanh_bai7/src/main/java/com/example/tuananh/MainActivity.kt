package com.example.tuananh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var imgback: ImageView? = null
    private var tv_left: TextView? = null
    private lateinit var sqlite: Sqlite
    private var tv_right: TextView? = null
    private lateinit var rclv: RecyclerView
    private var adapter: FolderAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        handletoolbar()
        sqlite=Sqlite.getDatabase(this)
        initRecyclerView()


    }

//    private fun getFolder() {
//        val fdList=sqlite.folderitemDao().getAllFolder()
//        Log.e("Main","${fdList.size}")
//        adapter?.additem(fdList as ArrayList<FolderModel>)
//    }

    private fun initRecyclerView() {
        rclv.layoutManager = LinearLayoutManager(this)

        val fdList=sqlite.folderitemDao().getAllFolder() as ArrayList<FolderModel>
        Log.e("Main","${fdList.size}")
        adapter = FolderAdapter(this,fdList)
        rclv.adapter = adapter
        adapter?.onItemClick={folder,position->
            val intent=Intent(this,EditConten::class.java)
            intent.putExtra(type,true)
            intent.putExtra("id",folder.id)
            intent.putExtra("title",folder.title)
            intent.putExtra("content",folder.content)
            startActivity(intent)
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun handletoolbar() {
        tv_left!!.visibility = View.GONE
        imgback!!.visibility = View.VISIBLE
        imgback!!.setImageDrawable(getDrawable(R.drawable.ic_back))
        var count = 0
        imgback!!.setOnClickListener {
            count++
            if (count > 1) {
                finishAffinity()
            } else {
                Toast.makeText(this, "Press back again to Leave!", Toast.LENGTH_SHORT).show()

                val handler = Handler(Looper.getMainLooper())

                handler.postDelayed({ count = 0 }, 2000)
            }

        }
        tv_right!!.setOnClickListener {
            val intent = Intent(this, EditConten::class.java)
            intent.putExtra(type, true)
            startActivity(intent)

        }

    }

    private fun initView() {
        imgback = findViewById(R.id.img_back)
        tv_left = findViewById(R.id.tv_left)

        tv_right = findViewById(R.id.tv_right)
        rclv = findViewById(R.id.rclv_btvn_7)
    }

    private var count = 0
    override fun onBackPressed() {
        count++
        if (count > 1) {
            finishAffinity()
        } else {
            Toast.makeText(this, "Press back again to Leave!", Toast.LENGTH_SHORT).show()

            // resetting the counter in 2s
            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({ count = 0 }, 2000)
        }
        super.onBackPressed()
    }

    companion object {
        const val type = "type"
    }
}




