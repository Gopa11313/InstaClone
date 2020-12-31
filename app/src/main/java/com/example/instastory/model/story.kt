package com.example.instastory.adapter

import android.os.Parcel
import android.os.Parcelable

class story(
    val id:Int?=null,
    val name:String?=null,
    val image:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<story> {
        override fun createFromParcel(parcel: Parcel): story {
            return story(parcel)
        }

        override fun newArray(size: Int): Array<story?> {
            return arrayOfNulls(size)
        }
    }
}