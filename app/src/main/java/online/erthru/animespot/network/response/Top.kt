package online.erthru.animespot.network.response

import com.google.gson.annotations.SerializedName
import online.erthru.animespot.network.model.Top

data class Top (

        @SerializedName("top") var top:ArrayList<Top>?

)