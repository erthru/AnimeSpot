package online.erthru.animespot.network.model

data class Season (

        var mal_id:Int?,
        var title:String?,
        var image_url:String?,
        var type:String?,
        var synopsis:String?,
        var producer:ArrayList<Producer>?,
        var episodes:String?,
        var source:String?,
        var score:Double?,
        var airing_start:String?

)