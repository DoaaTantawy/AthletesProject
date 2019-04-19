package iti.athletesproject

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Athlete {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("brief")
    @Expose
    var brief: String? = null

}
