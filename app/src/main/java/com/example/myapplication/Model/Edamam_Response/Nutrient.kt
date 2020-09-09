package com.example.myapplication.Model.Edamam_Response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Nutrient( val label : String,  val quantity : Double,  val unit : String) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Nutrient

        if (label != other.label) return false

        return true
    }

    override fun hashCode(): Int {
        return label.hashCode()
    }
}
