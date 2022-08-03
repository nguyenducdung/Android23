package com.tunanh.bai8

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "folder")
data class StudentModel(
    @PrimaryKey
    var id: Int,
    var name: String = "",
    var address: String = "",
    var phone: String = ""
)


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


