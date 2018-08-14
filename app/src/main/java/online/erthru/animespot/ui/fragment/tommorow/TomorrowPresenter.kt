package online.erthru.animespot.ui.fragment.today

import android.util.Log
import online.erthru.animespot.Utility
import online.erthru.animespot.network.ApiConfig
import online.erthru.animespot.network.response.Day
import retrofit2.Call
import retrofit2.Response

class TomorrowPresenter(val view:TomorrowContract.View) : TomorrowContract.Presenter{

    override fun loadTomorrow() {

        view.showProgressBar()
        ApiConfig().instance().airing(Utility.getTomorrow()?.toLowerCase())
                .enqueue(object : retrofit2.Callback<Day>{

                    override fun onFailure(call: Call<Day>?, t: Throwable?) {
                        view.dismissProgressBar()
                        view.showErrorMessage("Connection failed. Try again.")
                        Log.d("ONFAILURE",t.toString())
                    }

                    override fun onResponse(call: Call<Day>?, response: Response<Day>?) {

                        view.dismissProgressBar()
                        if(Utility.getTomorrow()?.equals("Monday")!!){
                            view.tomorrowLoaded(response?.body()?.monday)
                        }else if(Utility.getTomorrow()?.equals("Tuesday")!!){
                            view.tomorrowLoaded(response?.body()?.tuesday)
                        }else if(Utility.getTomorrow()?.equals("Wednesday")!!){
                            view.tomorrowLoaded(response?.body()?.wednesday)
                        }else if(Utility.getTomorrow()?.equals("Thursday")!!){
                            view.tomorrowLoaded(response?.body()?.thursday)
                        }else if(Utility.getTomorrow()?.equals("Friday")!!){
                            view.tomorrowLoaded(response?.body()?.friday)
                        }else if(Utility.getTomorrow()?.equals("Saturday")!!){
                            view.tomorrowLoaded(response?.body()?.saturday)
                        }else if(Utility.getTomorrow()?.equals("Sunday")!!){
                            view.tomorrowLoaded(response?.body()?.sunday)
                        }

                    }

                })

    }

}