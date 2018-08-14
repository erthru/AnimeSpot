package online.erthru.animespot.ui.activity.search

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Result

interface SearchContract {

    interface Presenter{
        fun search(query:String?)
    }

    interface View:BaseView{
        fun searchResult(data:ArrayList<Result>?)
    }

}