package online.erthru.animespot.ui.activity.season

import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Season
import retrofit2.Call
import retrofit2.Response

class SeasonPresenter(val view: SeasonContract.View) : SeasonContract.Presenter {

    override fun loadSeason(season: String?, year: String?) {

        view.showProgressBar()

        ApiConfig().instance().season(year,season)
                .enqueue(object : retrofit2.Callback<Season>{

                    override fun onFailure(call: Call<Season>?, t: Throwable?) {
                        view.showErrorMessage("Connection failed. Try again.")
                        view.closeActivity()
                    }

                    override fun onResponse(call: Call<Season>?, response: Response<Season>?) {

                        view.dismissProgressBar()
                        view.seasonLoaded(response?.body()?.season!!)

                    }

                })

    }

}