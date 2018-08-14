package online.erthru.animespot.network.response

import com.google.gson.annotations.SerializedName
import online.erthru.animespot.network.model.Day

data class Day(

    @SerializedName("monday") var monday:ArrayList<Day>?,
    @SerializedName("tuesday") var tuesday:ArrayList<Day>?,
    @SerializedName("wednesday") var wednesday:ArrayList<Day>?,
    @SerializedName("thursday") var thursday:ArrayList<Day>?,
    @SerializedName("friday") var friday:ArrayList<Day>?,
    @SerializedName("saturday") var saturday:ArrayList<Day>?,
    @SerializedName("sunday") var sunday:ArrayList<Day>?

)