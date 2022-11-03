package com.ridennator.androidapi.Ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ridennator.androidapi.Model.Note
import com.ridennator.androidapi.R
import com.ridennator.androidapi.Ui.Adapter.NoteListAdapter
import com.ridennator.androidapi.retrofit.retrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call=retrofitInitializer().noteService().list()
        call.enqueue(
            object : Callback<List<Note>?>{
                override fun onResponse(call: Call<List<Note>?>, response: Response<List<Note>?>?) {
                    response?.body()?.let { val notes:List<Note> = it}
                    configureList(nodes)
                }
            }
            override fun onFailure(call:Call<List<Note>?>?,t:Throwable?){
                t?.message?.let { Log.e("Something went wrong",it)}
            }
        )
    }
    private fun configureList(notes:List<Note>){
        val reciclerView=findViewById<RecyclerView>(R.id.nodeListReciclerView)
        reciclerView.adapter= NoteListAdapter(notes, this)
        val layoutManager=StaggeredGridLayoutManager(
            2, StaggeredGridLayoutManager.VERTICAL
        )
        reciclerView.layoutManager=layoutManager
    }
}