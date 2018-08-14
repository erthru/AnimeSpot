package online.erthru.animespot.ui.activity.search

import android.util.Log
import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Search
import retrofit2.Call
import retrofit2.Response

class SearchPresenter(val v:SearchContract.View) : SearchContract.Presenter{

    override fun search(query: String?) {

        v.showProgressBar()
        ApiConfig().instance().search(query)
                .enqueue(object : retrofit2.Callback<Search>{

                    override fun onFailure(call: Call<Search>?, t: Throwable?) {
                        v.dismissProgressBar()
                        v.showErrorMessage("Connection failed, Try again.")
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<Search>?, response: Response<Search>?) {

                        v.dismissProgressBar()
                        v.searchResult(response?.body()?.result)

                    }

                })

    }

}