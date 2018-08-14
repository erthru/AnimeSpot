package online.erthru.animespot.ui.fragment.today

import android.util.Log
import online.erthru.animespot.Utility
import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Day
import retrofit2.Call
import retrofit2.Response

class TodayPresenter(val view:TodayContract.View) : TodayContract.Presenter{

    override fun loadToday() {

        view.showProgressBar()
        ApiConfig().instance().airing(Utility.getToDay()?.toLowerCase())
                .enqueue(object : retrofit2.Callback<Day>{

                    override fun onFailure(call: Call<Day>?, t: Throwable?) {
                        view.dismissProgressBar()
                        view.showErrorMessage("Connection failed. Try again.")
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<Day>?, response: Response<Day>?) {

                        view.dismissProgressBar()
                        if(Utility.getToDay()?.equals("Monday")!!){
                            view.todayLoaded(response?.body()?.monday)
                        }else if(Utility.getToDay()?.equals("Tuesday")!!){
                            view.todayLoaded(response?.body()?.tuesday)
                        }else if(Utility.getToDay()?.equals("Wednesday")!!){
                            view.todayLoaded(response?.body()?.wednesday)
                        }else if(Utility.getToDay()?.equals("Thursday")!!){
                            view.todayLoaded(response?.body()?.thursday)
                        }else if(Utility.getToDay()?.equals("Friday")!!){
                            view.todayLoaded(response?.body()?.friday)
                        }else if(Utility.getToDay()?.equals("Saturday")!!){
                            view.todayLoaded(response?.body()?.saturday)
                        }else if(Utility.getToDay()?.equals("Sunday")!!){
                            view.todayLoaded(response?.body()?.sunday)
                        }

                    }

                })

    }

}