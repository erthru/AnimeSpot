package online.erthru.animespot.network

import online.erthru.animespot.network.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("season/{year}/{season}")
    fun season(
            @Path("year")year:String?,
            @Path("season")season:String?
    ) : Call<Season>

    @GET("anime/{id}")
    fun anime(
            @Path("id")id:Int?
    ) : Call<Anime>

    @GET("anime/{id}/characters_staff")
    fun animeStaff(
            @Path("id")id:Int?
    ) : Call<Staff>

    @GET("schedule/{day}")
    fun airing(
            @Path("day")day:String?
    ) : Call<Day>

    @GET("search/anime/{query}")
    fun search(
            @Path("query")query:String?
    ) : Call<Search>

    @GET("top/anime")
    fun top() : Call<Top>

}