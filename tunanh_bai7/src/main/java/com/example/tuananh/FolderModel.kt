package com.example.tuananh
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="folder")
data class FolderModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title:String="",
    var content: String="")


//): Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readString().toString(),
//        parcel.readString().toString()
//    ) {
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeInt(id)
//        dest.writeString(title)
//        dest.writeString(content)
//    }
//
//    companion object CREATOR : Parcelable.Creator<FolderModel> {
//        override fun createFromParcel(parcel: Parcel): FolderModel {
//            return FolderModel(parcel)
//        }
//
//        override fun newArray(size: Int): Array<FolderModel?> {
//            return arrayOfNulls(size)
//        }
//    }
//}


