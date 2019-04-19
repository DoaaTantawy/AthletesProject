package iti.athletesproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_athlete_details.*

class AthleteDetails : AppCompatActivity() {

    internal lateinit var data: String
    internal lateinit var imgUrl: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_athlete_details)

        val incomingIntent = intent
        data = incomingIntent.getStringExtra(MainActivity.NAME)
        nameV.setText(data)
        data = incomingIntent.getStringExtra(MainActivity.BRIEF)
        briefV.setText(data)
        imgUrl = incomingIntent.getStringExtra(MainActivity.IMGATHLETE)


        if (imgUrl === "") {
            imgAth.visibility=View.GONE
        } else {
            Glide.with(this).load(imgUrl).into(imgAth)
        }


    }
}
