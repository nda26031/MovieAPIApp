package com.example.movieapiapp.ui.fragments.home.nowplaying

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapiapp.R
import com.example.movieapiapp.ui.data.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingFragment : Fragment() {

    private val retrofitInstance = RetrofitInstance.api
    private val nowPlayingMovieAdapter = NowPlayingMovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_now_playing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rcvNowPlaying)
        recyclerView.adapter = nowPlayingMovieAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        retrofitInstance.getPlayingMovieList("ccea8d7b622a323de74dbfad8ec0a374")
            .enqueue(object : Callback<NowPlayingMovieState> {
                override fun onResponse(
                    call: Call<NowPlayingMovieState>,
                    response: Response<NowPlayingMovieState>
                ) {
                    if (response.isSuccessful) {
                        nowPlayingMovieAdapter.submitList(response.body()?.results)
                        recyclerView.adapter = nowPlayingMovieAdapter
                    }
                }

                override fun onFailure(call: Call<NowPlayingMovieState>, t: Throwable) {
                    Log.d("TAG", t.message.toString())

                }


            })

    }

}