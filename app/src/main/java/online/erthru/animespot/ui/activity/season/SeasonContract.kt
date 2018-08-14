package online.erthru.animespot.ui.activity.season

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Season

interface SeasonContract {

    interface Presenter{
        fun loadSeason(season:String?,year:String?)
    }

    interface View:BaseView{
        fun seasonLoaded(data:ArrayList<Season>)
    }

}