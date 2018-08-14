package online.erthru.animespot.network.response

import com.google.gson.annotations.SerializedName
import online.erthru.animespot.network.model.Result

data class Search(

        @SerializedName("result") var result:ArrayList<Result>?

)