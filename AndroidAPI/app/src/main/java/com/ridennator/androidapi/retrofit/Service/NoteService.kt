package com.ridennator.androidapi.retrofit.Service

import com.ridennator.androidapi.model.APIResult
import com.ridennator.androidapi.model.Note
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * specify the 'url' that we want to access
 */

interface NoteService {
    @GET("api/notes")
    fun list(): Call<List<Note>>

    @POST("api/notes")
    fun addNote(@Body note: Note): Call<APIResult>

}