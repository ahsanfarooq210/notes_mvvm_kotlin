package com.example.notes_mvvm_kotlin.Model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes" )
class Notes(

    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,

    var title:String,

    var subTitle:String,

    var notes:String,

    val date:String,

    var priority:String
): Parcelable
{
    constructor(parcel: Parcel) : this(
        id=parcel.readValue(Int::class.java.classLoader) as? Int,
        title=parcel.readString()!!,
        subTitle=parcel.readString()!!,
        notes=parcel.readString()!!,
        date=parcel.readString()!!,
        priority=parcel.readString()!!
    )
    {
    }

    override fun describeContents(): Int
    {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int)
    {
        p0!!.writeInt(id!!)
        p0.writeString(title)
        p0.writeString(subTitle)
        p0.writeString(notes)
        p0.writeString(date)
        p0.writeString(priority)
    }

    companion object CREATOR : Parcelable.Creator<Notes>
    {
        override fun createFromParcel(parcel: Parcel): Notes
        {
            return Notes(parcel)
        }

        override fun newArray(size: Int): Array<Notes?>
        {
            return arrayOfNulls(size)
        }
    }
}
