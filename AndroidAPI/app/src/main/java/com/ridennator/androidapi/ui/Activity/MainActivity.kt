package com.ridennator.androidapi.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ridennator.androidapi.model.Note
import com.ridennator.androidapi.R
import com.ridennator.androidapi.ui.adapter.NoteListAdapter
import com.ridennator.androidapi.retrofit.retrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call=retrofitInitializer().noteService().list()
        call.enqueue(
            object : Callback<List<Note>?>{
                override fun onResponse(
                    call: Call<List<Note>?>?, response: Response<List<Note>?>?) {
                    response?.body()?.let { val notes:List<Note> = it
                        configureList(notes)
                        }

                }
            override fun onFailure(call:Call<List<Note>?>?,t:Throwable?) {
                t?.message?.let { Log.e("Something went wrong", it) }
            }
        })
    }
    private fun configureList(notes:List<Note>){
        val recyclerview=findViewById<RecyclerView>(R.id.nodeListRecyclerView)
        recyclerview.adapter= NoteListAdapter(notes, this)
        val layoutManager=StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )
        recyclerview.layoutManager=layoutManager
    }
}


