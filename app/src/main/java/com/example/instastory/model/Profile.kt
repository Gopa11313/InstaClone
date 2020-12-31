package com.example.instastory.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Profile(
    val cid:Int?=null,
    val fname:String?=null,
    val lname:String?=null,
    val email:String?=null,
    val password:String?=null,
    val batch:String?=null,
    val img:String?=null
              ):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(cid)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(email)
        parcel.writeString(password)
        parcel.writeString(batch)
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Profile> {
        override fun createFromParcel(parcel: Parcel): Profile {
            return Profile(parcel)
        }

        override fun newArray(size: Int): Array<Profile?> {
            return arrayOfNulls(size)
        }
    }

}