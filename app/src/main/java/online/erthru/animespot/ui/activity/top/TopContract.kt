package online.erthru.animespot.ui.activity.top

import online.erthru.animespot.base.BaseView
import online.erthru.animespot.network.model.Top

interface TopContract{

    interface Presenter{
        fun loadTop()
    }

    interface View:BaseView{
        fun topLoaded(data:ArrayList<Top>?)
    }

}