package com.example.tuananh

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class Sqlite(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="folder.db"
        private val TB_FOLDER="tb_folder"
        private val ID="id"
        private val TITLE="title"
        private val CONTENT="content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createtbFolder=("CREATE TABLE $TB_FOLDER($ID INTEGER PRIMARY KEY,$TITLE TEXT,$CONTENT TEXT)")
        db?.execSQL(createtbFolder)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TB_FOLDER")
        onCreate(db)
    }
    fun insertFolder(folderModel: FolderModel):Long{
        val db= this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(ID,folderModel.id)
        contentValues.put(TITLE,folderModel.title)
        contentValues.put(CONTENT,folderModel.content)

        val insert=db.insert(TB_FOLDER,null,contentValues)
        db.close()
        return insert
    }
    @SuppressLint("Range")
    fun getallFolder():ArrayList<FolderModel>{
        val fdList:ArrayList<FolderModel> = ArrayList()
        val selectQuery="SELECT * FROM $TB_FOLDER"
        val db=this.readableDatabase
        val cursor:Cursor
        try {
            cursor=db.rawQuery(selectQuery,null)
        }catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id:Int
        var title:String
        var content:String
        if (cursor.moveToFirst()){
            do {
                id=cursor.getInt(cursor.getColumnIndex(ID))
                title=cursor.getString(cursor.getColumnIndex(TITLE))
                content=cursor.getString(cursor.getColumnIndex(CONTENT))
                val folderModel=FolderModel(id=id, title=title,content=content)
                fdList.add(folderModel)
            }while (cursor.moveToNext())
        }
        return fdList

    }
    fun updateFolder(){

    }
}