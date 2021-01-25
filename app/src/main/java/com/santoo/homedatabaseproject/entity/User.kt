package com.santoo.homedatabaseproject.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

        var firstName: String? = null,
        var lastName : String? = null,
        var userName: String? = null,
        var password: String? = null,
) {
        @PrimaryKey(autoGenerate = true)
        var userId : Int = 0
}

