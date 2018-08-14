package online.erthru.animespot.ui.activity.anime

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Genre
import online.erthru.animespot.network.model.Staff

interface AnimeContract {

    interface Presenter{
        fun loadDetail(id:Int?)
        fun loadStaff(id:Int?)
    }

    interface View:BaseView{
        fun detailLoaded(data:HashMap<String,Any>?, genre:ArrayList<Genre>?)
        fun staffLoaded(data:ArrayList<Staff>?)
    }

}