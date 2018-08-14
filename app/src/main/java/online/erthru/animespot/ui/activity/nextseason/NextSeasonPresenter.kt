package online.erthru.animespot.ui.activity.nextseason

import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Season
import retrofit2.Call
import retrofit2.Response

class NextSeasonPresenter(val v:NextSeasonContract.View) : NextSeasonContract.Presenter {

    override fun loadSeason(season: String?, year: String?) {

        v.showProgressBar()

        ApiConfig().instance().season(year,season)
                .enqueue(object : retrofit2.Callback<Season>{

                    override fun onFailure(call: Call<Season>?, t: Throwable?) {
                        v.showErrorMessage("Connection failed. Try again.")
                        v.closeActivity()
                    }

                    override fun onResponse(call: Call<Season>?, response: Response<Season>?) {
                        v.dismissProgressBar()
                        v.seasonLoaded(response?.body()?.season)
                    }

                })

    }

}