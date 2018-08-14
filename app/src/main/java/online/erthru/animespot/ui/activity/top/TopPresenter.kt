package online.erthru.animespot.ui.activity.top

import android.util.Log
import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Top
import retrofit2.Call
import retrofit2.Response

class TopPresenter(val v:TopContract.View) : TopContract.Presenter{

    override fun loadTop() {

        v.showProgressBar()
        ApiConfig().instance().top()
                .enqueue(object : retrofit2.Callback<Top>{

                    override fun onFailure(call: Call<Top>?, t: Throwable?) {
                        v.showErrorMessage("Connection failed. Try again")
                        v.dismissProgressBar()
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<Top>?, response: Response<Top>?) {

                        v.dismissProgressBar()
                        v.topLoaded(response?.body()?.top)

                    }

                })

    }

}