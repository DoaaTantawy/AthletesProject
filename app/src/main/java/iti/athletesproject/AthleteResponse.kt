package iti.athletesproject

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AthleteResponse{
    @SerializedName("athletes")
    @Expose
    var athletes: List<Athlete>? = null
}
