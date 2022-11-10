package com.ridennator.androidapi.model

import com.google.gson.annotations.SerializedName

/**
 * define data structure to add dat to API
 */

class APIResult (
        @SerializedName("title") val title:String?,
        @SerializedName("description") val description:String?
        )