package online.erthru.animespot.ui.activity.nextseason

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Season

interface NextSeasonContract{

    interface Presenter{
        fun loadSeason(season:String?, year:String?)
    }

    interface View:BaseView{
        fun seasonLoaded(data:ArrayList<Season>?)
    }

}