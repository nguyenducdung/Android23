package com.dungnd.android23.buoi7

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class Buoi7RecycleviewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycleviewbuoi7)

        val rcvData = findViewById<RecyclerView>(R.id.rcvData)
        val adapter = Buoi7RecycleviewAdapter(createFolderList())
        adapter.onClickItem = {
            val intent = Intent(this, Buoi7BarActivity::class.java)
            intent.putExtra("key1",it.title)
            intent.putExtra("key2",it.content)
            startActivity(intent)

        }
        rcvData.adapter=adapter
    }

    private fun createFolderList(): List<Folder>{
        val folderList : MutableList<Folder> = ArrayList()
        var folder = Folder().apply {
            this.title="Tong hop tin tuc thoi su"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Do it your self"
            this.content="Son Tung MT-P qua dep trai hat hay "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Cam hung sang tao"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Tong hop tin tuc thoi su"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Do it your self"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Tong hop tin tuc thoi su"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Tong hop tin tuc thoi su"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        folder = Folder().apply {
            this.title="Tong hop tin tuc thoi su"
            this.content="Tong hop tin tuc thoi su nong hoi, cua tat ca cac  "
        }
        folderList.add(folder)
        return folderList

    }
}

