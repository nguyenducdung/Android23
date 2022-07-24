package BTVN_buoi6_bai2

import BTVN_buoi6_bai1.Chat
import BTVN_buoi6_bai1.ChatAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dungnd.android23.R

class DogActivity : AppCompatActivity() {

    lateinit var rcvData: RecyclerView
    val dogList: MutableList<Dog> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_dog)
        rcvData = findViewById(R.id.rcvData)
        addData()
        initRecyclerView()
    }

    fun addData() {
        val dogItem1 = Dog().apply {
            this.vImage = R.drawable.dog1
            this.contentClick = "Chó 1"
        }
        val dogItem2 = Dog().apply {
            this.vImage = R.drawable.dog2
            this.contentClick = "Chó 2"
        }
        val dogItem3 = Dog().apply {
            this.vImage = R.drawable.dog3
            this.contentClick = "Chó 3"
        }
        val dogItem4 = Dog().apply {
            this.vImage = R.drawable.dog4
            this.contentClick = "Chó 4"
        }
        val dogItem5 = Dog().apply {
            this.vImage = R.drawable.dog5
            this.contentClick = "Chó 5"
        }
        val dogItem6 = Dog().apply {
            this.vImage = R.drawable.dog6
            this.contentClick = "Chó 6"
        }
        val dogItem7 = Dog().apply {
            this.vImage = R.drawable.dog7
            this.contentClick = "Chó 7"
        }
        val dogItem8 = Dog().apply {
            this.vImage = R.drawable.dog8
            this.contentClick = "Chó 8"
        }
        val dogItem9 = Dog().apply {
            this.vImage = R.drawable.dog9
            this.contentClick = "Chó 9"
        }
        val dogItem10 = Dog().apply {
            this.vImage = R.drawable.dog10
            this.contentClick = "Chó 10"
        }
        val dogItem11 = Dog().apply {
            this.vImage = R.drawable.dog11
            this.contentClick = "Chó 11"
        }
        val dogItem12 = Dog().apply {
            this.vImage = R.drawable.dog12
            this.contentClick = "Chó 12"
        }
        dogList.add(dogItem1)
        dogList.add(dogItem2)
        dogList.add(dogItem3)
        dogList.add(dogItem4)
        dogList.add(dogItem5)
        dogList.add(dogItem6)
        dogList.add(dogItem7)
        dogList.add(dogItem8)
        dogList.add(dogItem9)
        dogList.add(dogItem10)
        dogList.add(dogItem11)
        dogList.add(dogItem12)
    }

    fun initRecyclerView() {
        val adapter = DogAdapter(dogList, this)
        rcvData.adapter = adapter
        adapter.onClickitem = { Dog ->
            Toast.makeText(this, "${Dog.contentClick}", Toast.LENGTH_SHORT).show();
        }
    }

}