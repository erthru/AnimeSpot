package online.erthru.animespot.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.ProgressBar
import com.afollestad.materialdialogs.MaterialDialog
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable
import com.jpardogo.android.googleprogressbar.library.FoldingCirclesDrawable
import com.valdesekamdem.library.mdtoast.MDToast
import online.erthru.animespot.R

open class BaseFragment : Fragment(),BaseView{

    lateinit var loading: MaterialDialog
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dialog = MaterialDialog.Builder(context!!)
        dialog.content("Please wait...")
        dialog.progress(true,0)
        dialog.cancelable(false)
        loading = dialog.build()

    }

    fun initProgressBar(progressBar: ProgressBar){
        this.progressBar = progressBar
        this.progressBar.indeterminateDrawable = FoldingCirclesDrawable.Builder(context)
                .colors(resources.getIntArray(R.array.pb_color))
                .build()
    }

    override fun showLoadingProgress() {
        loading.show()
    }

    override fun dismissLoadingProgress() {
        if(loading.isShowing)
            loading.dismiss()
    }

    override fun showErrorMessage(message: String?) {
        MDToast.makeText(context!!,message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
    }

    override fun showSuccessMessage(message: String?) {
        MDToast.makeText(context!!,message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
    }

    override fun showInfoMessage(message: String?) {
        MDToast.makeText(context!!,message, MDToast.LENGTH_SHORT, MDToast.TYPE_INFO).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun closeActivity() {
    }

}