package com.ridennator.androidapi.model

import com.google.gson.annotations.SerializedName

/**
 * class to represent the data stucture,
 * obtained from API
 */
class Note(
    @SerializedName("title") val title:String,
    @SerializedName("description") val description:String)
