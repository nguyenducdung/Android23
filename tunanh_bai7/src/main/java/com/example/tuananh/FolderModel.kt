package com.example.tuananh

import android.service.quicksettings.Tile
import kotlin.random.Random

class FolderModel(
    var id:Int=getAutoId(),
    var title:String="",
    var content: String=""


) {
   companion object{
       fun getAutoId():Int{
           val random= java.util.Random()
           return random.nextInt(100)
       }
   }
}