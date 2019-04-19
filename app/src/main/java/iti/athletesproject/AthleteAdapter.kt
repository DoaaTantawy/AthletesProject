package iti.athletesproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.*

class AthleteAdapter(internal var mContext: Context, athleteArray: ArrayList<Athlete>) : ArrayAdapter<Athlete>(mContext, 0, athleteArray) {

    internal var athleteArrayList: ArrayList<Athlete>

    init {
        athleteArrayList = ArrayList()
        athleteArrayList = athleteArray

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.athlete_item, parent, false)

        }

        val nameView = listItemView!!.findViewById<View>(R.id.athName) as TextView
        nameView.text = "" + athleteArrayList[position].name!!


        val athleteImg = listItemView.findViewById<View>(R.id.athImg) as ImageView
        if (athleteArrayList[position].image != "") {
            Glide.with(mContext)
                .load(athleteArrayList[position].image).into(athleteImg)
        } else {
            athleteImg.visibility=View.GONE
        }
        val briefView = listItemView.findViewById<View>(R.id.athBrief) as TextView
        briefView.text = athleteArrayList[position].brief



        return listItemView
    }


}

