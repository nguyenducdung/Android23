package btvn_buoi8

import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView

class SinhVien(): Parcelable {
    var id: Int? = null
    var tvName : String? = null
    var tvAdress : String? = null
    var tvPhone : String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        tvName = parcel.readString()
        tvAdress = parcel.readString()
        tvPhone = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(tvName)
        parcel.writeString(tvAdress)
        parcel.writeString(tvPhone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SinhVien> {
        override fun createFromParcel(parcel: Parcel): SinhVien {
            return SinhVien(parcel)
        }

        override fun newArray(size: Int): Array<SinhVien?> {
            return arrayOfNulls(size)
        }
    }

}