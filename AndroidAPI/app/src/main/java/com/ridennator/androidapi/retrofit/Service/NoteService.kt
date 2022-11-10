package com.ridennator.androidapi.retrofit.Service

import com.ridennator.androidapi.model.Note
import retrofit2.Call
import retrofit2.http.GET

/**
 * specify the 'url' that we want to access
 */

interface NoteService {
    @GET("api/notes")
    fun list(): Call<List<Note>>

}