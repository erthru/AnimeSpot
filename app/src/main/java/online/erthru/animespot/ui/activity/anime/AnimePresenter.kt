package online.erthru.animespot.ui.activity.anime

import android.util.Log
import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Anime
import online.erthru.animespot.network.response.Staff
import retrofit2.Call
import retrofit2.Response

class AnimePresenter(val view: AnimeContract.View) : AnimeContract.Presenter {

    override fun loadDetail(id: Int?) {

        view.showProgressBar()

        ApiConfig().instance().anime(id)
                .enqueue(object : retrofit2.Callback<Anime>{

                    override fun onFailure(call: Call<Anime>?, t: Throwable?) {
                        view.showErrorMessage("Connection failed. Try again.")
                        view.closeActivity()
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<Anime>?, response: Response<Anime>?) {

                        val map = HashMap<String, Any>()
                        map.put("title",response?.body()?.title!!)
                        map.put("title_japanese",response?.body()?.title_japanese!!)
                        map.put("image_url",response?.body()?.image_url!!)
                        map.put("type",response?.body()?.type!!)
                        map.put("source",response?.body()?.source!!)
                        map.put("status",response?.body()?.status!!)
                        map.put("aired_string",response?.body()?.aired_string!!)
                        map.put("duration",response?.body()?.duration!!)
                        map.put("rating",response?.body()?.rating!!)
                        map.put("score",response?.body()?.score!!)
                        map.put("scored_by",response?.body()?.scored_by!!)
                        map.put("rank",response?.body()?.rank ?: 0)
                        map.put("popularity",response?.body()?.popularity!!)
                        map.put("members",response?.body()?.members!!)
                        map.put("favorites",response?.body()?.favorites!!)
                        map.put("synopsis",response?.body()?.synopsis!!)
                        map.put("broadcast",response?.body()?.broadcast ?: "-")

                        if(response?.body()?.producer?.size == 0){
                            map.put("producer","null")
                        }else{
                            map.put("producer",response?.body()?.producer?.get(0)?.name!!)
                        }
                        view.detailLoaded(map,response?.body()?.genre)
                        view.dismissProgressBar()

                    }

                })

    }

    override fun loadStaff(id: Int?) {

        ApiConfig().instance().animeStaff(id)
                .enqueue(object : retrofit2.Callback<Staff>{
                    override fun onFailure(call: Call<Staff>?, t: Throwable?) {
                        view.showErrorMessage("Connection failed. Try again.")
                        view.closeActivity()
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<Staff>?, response: Response<Staff>?) {

                        view.staffLoaded(response?.body()?.staff)

                    }

                })

    }

}