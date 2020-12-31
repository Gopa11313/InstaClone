package com.example.instastory.model

import android.os.Parcel
import android.os.Parcelable

class ExtraPost(
    val img:String?=null,
    val status:String?=null
    ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExtraPost> {
        override fun createFromParcel(parcel: Parcel): ExtraPost {
            return ExtraPost(parcel)
        }

        override fun newArray(size: Int): Array<ExtraPost?> {
            return arrayOfNulls(size)
        }
    }
}