package BTVN_buoi6_bai1

import BTVN_buoi3_bai3.Bai3
import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class ChatActivity : AppCompatActivity() {
    lateinit var rcvData: RecyclerView
    val chatList: MutableList<Chat> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        rcvData = findViewById(R.id.rcvData)
        addData()
        initRecyclerView()
    }

    fun addData() {

        val chatItem = Chat().apply {
            this.vImage = R.drawable.avatar1
            this.tvName = "James"
            this.tvCmt = "Thank you! That was very helpful!"
            this.contentClick = "Hello James"
        }
        val chatItem2 = Chat().apply {
            this.vImage = R.drawable.avatar2
            this.tvName = "Will Kenny"
            this.tvCmt = "I know... I’m trying to get the funds."
            this.contentClick = "Hello Will Kenny"


        }
        val chatItem3 = Chat().apply {
            this.vImage = R.drawable.avatar3
            this.tvName = "Beth Williams"
            this.tvCmt = "I’m looking for tips around capturing the milky way. I have a 6D with a 24-100mm..."
            this.contentClick = "Hello James Beth Williams"
        }
        val chatItem4 = Chat().apply {
            this.vImage = R.drawable.avatar4
            this.tvName = "Rev Shawn"
            this.tvCmt = "Wanted to ask if you’re available for a portrait shoot next week."
            this.contentClick = "Hello Rev Shawn"
        }
        chatList.add(chatItem)
        chatList.add(chatItem2)
        chatList.add(chatItem3)
        chatList.add(chatItem4)
    }
    fun initRecyclerView() {
        val adapter = ChatAdapter(chatList, this)
        adapter.onClickitem = { chat ->
            Toast.makeText(this, "${chat.contentClick}", Toast.LENGTH_SHORT).show();
        }
        rcvData.adapter = adapter

    }


}