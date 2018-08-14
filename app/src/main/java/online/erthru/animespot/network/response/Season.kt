package online.erthru.animespot.network.response

import com.google.gson.annotations.SerializedName
import online.erthru.animespot.network.model.Season

data class Season(

        @SerializedName("season") var season:ArrayList<Season>?

)