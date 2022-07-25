package com.dungnd.android23.buoi7

import android.os.Parcel
import android.os.Parcelable

class SeventData() : Parcelable {
    var title: String = ""
    var content: String = ""

    constructor(parcel: Parcel) : this() {
        title = parcel.readString().toString()
        content = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SeventData> {
        override fun createFromParcel(parcel: Parcel): SeventData {
            return SeventData(parcel)
        }

        override fun newArray(size: Int): Array<SeventData?> {
            return arrayOfNulls(size)
        }
    }

}