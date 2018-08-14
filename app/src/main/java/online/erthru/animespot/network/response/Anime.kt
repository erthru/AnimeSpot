package online.erthru.animespot.network.response

import com.google.gson.annotations.SerializedName
import online.erthru.animespot.network.model.Genre
import online.erthru.animespot.network.model.Producer

data class Anime(

        @SerializedName("title") var title:String?,
        @SerializedName("title_japanese") var title_japanese:String?,
        @SerializedName("image_url") var image_url:String?,
        @SerializedName("type") var type:String?,
        @SerializedName("source") var source:String?,
        @SerializedName("status") var status:String?,
        @SerializedName("aired_string") var aired_string:String?,
        @SerializedName("duration") var duration:String?,
        @SerializedName("rating") var rating:String?,
        @SerializedName("score") var score:Double?,
        @SerializedName("scored_by") var scored_by:Int?,
        @SerializedName("rank") var rank:Int?,
        @SerializedName("popularity") var popularity:Int?,
        @SerializedName("members") var members:Int?,
        @SerializedName("favorites") var favorites:Int?,
        @SerializedName("synopsis") var synopsis:String?,
        @SerializedName("broadcast") var broadcast:String?,
        @SerializedName("producer") var producer: ArrayList<Producer>?,
        @SerializedName("genre") var genre:ArrayList<Genre>?

)