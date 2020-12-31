package com.example.instastory.model

import android.os.Parcel
import android.os.Parcelable

class post(val id:Int?=null,
            val img1:String?=null,
            val name:String?=null,
           val img2:String?=null,
           val likes:String?=null,
           val discriptio:String?=null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(img1)
        parcel.writeString(img2)
        parcel.writeString(likes)
        parcel.writeString(discriptio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<post> {
        override fun createFromParcel(parcel: Parcel): post {
            return post(parcel)
        }

        override fun newArray(size: Int): Array<post?> {
            return arrayOfNulls(size)
        }
    }

}