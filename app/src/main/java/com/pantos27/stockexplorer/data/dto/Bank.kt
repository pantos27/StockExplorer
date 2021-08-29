package com.pantos27.stockexplorer.data.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bank(val name: String,val stk: String, val img: String,val priority: Int): Parcelable{
    override fun toString() = "$name\n($stk)"
}
