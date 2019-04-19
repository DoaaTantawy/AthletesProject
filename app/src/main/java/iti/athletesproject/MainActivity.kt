package iti.athletesproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    internal lateinit var retrofitAdapter: AthleteAdapter
    internal lateinit var listView: ListView
    private lateinit var athletes: ArrayList<Athlete>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        athletes = ArrayList()
        listView = findViewById<View>(R.id.list) as ListView
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create<GsonResponse>(GsonResponse::class.java!!)
        val call = service.ath



        call.enqueue(object : Callback<AthleteResponse> {
            override fun onResponse(call: Call<AthleteResponse>, response: Response<AthleteResponse>) {
                athletes = (response.body()!!.athletes as ArrayList<Athlete>?)!!
                retrofitAdapter = AthleteAdapter(this@MainActivity, athletes)
                listView.adapter = retrofitAdapter
                listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                    val athleteName = athletes!![i].name
                    val brief = athletes!![i].brief
                    val athleteImg = athletes!![i].image
                    val intent = Intent(this@MainActivity, AthleteDetails::class.java)
                    intent.putExtra(NAME, athleteName)
                    intent.putExtra(BRIEF, brief)
                    intent.putExtra(IMGATHLETE, athleteImg)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<AthleteResponse>, t: Throwable) {

            }
        })


    }

    companion object {
        val NAME = "name"
        val BRIEF = "brief"
        val IMGATHLETE = "imgathlete"
    }


}
