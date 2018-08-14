package online.erthru.animespot.ui.activity.top

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_top.*
import online.erthru.animespot.R
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.network.model.Top

class TopActivity : BaseActivity(),TopContract.View {

    lateinit var presenter:TopContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorPurpleDark)
        }

        initProgressBar(pbTop)

        presenter = TopPresenter(this)

        imgBackTop.setOnClickListener { this.finish() }

        rvTop.layoutManager = LinearLayoutManager(this)
        rvTop.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

    }

    override fun onResume() {
        super.onResume()
        rvTop.adapter = null
        presenter.loadTop()
    }

    override fun topLoaded(data: ArrayList<Top>?) {
        val adapter = TopRecyclerView(this,data)
        adapter.notifyDataSetChanged()
        rvTop.adapter = adapter
    }

}
