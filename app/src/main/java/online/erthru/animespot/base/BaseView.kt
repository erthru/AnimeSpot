package online.erthru.animespot.base

import android.widget.ProgressBar

interface BaseView{

    fun showLoadingProgress()
    fun dismissLoadingProgress()
    fun showErrorMessage(message:String?)
    fun showSuccessMessage(message:String?)
    fun showInfoMessage(message:String?)
    fun showProgressBar()
    fun dismissProgressBar()
    fun closeActivity()

}