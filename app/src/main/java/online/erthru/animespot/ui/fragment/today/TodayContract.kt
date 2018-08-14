package online.erthru.animespot.ui.fragment.today

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Day

interface TodayContract {

    interface Presenter{
        fun loadToday()
    }

    interface View:BaseView{
        fun todayLoaded(data:ArrayList<Day>?)
    }

}