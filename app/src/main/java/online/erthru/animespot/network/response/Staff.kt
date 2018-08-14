package online.erthru.animespot.network.response

import com.google.gson.annotations.SerializedName
import online.erthru.animespot.network.model.Staff

data class Staff (
        @SerializedName("staff") var staff:ArrayList<Staff>?
)