package online.erthru.animespot.ui.fragment.today

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Day

interface TomorrowContract {

    interface Presenter{
        fun loadTomorrow()
    }

    interface View:BaseView{
        fun tomorrowLoaded(data:ArrayList<Day>?)
    }

}