package online.erthru.animespot.ui.activity.season

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_season.*
import online.erthru.animespot.R
import online.erthru.animespot.Utility
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.network.model.Season

class SeasonActivity : BaseActivity(), SeasonContract.View {

    lateinit var presenter: SeasonContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorPinkDark)
        }

        initProgressBar(pbSeason)

        rvSeason.layoutManager = LinearLayoutManager(this)
        rvSeason.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        presenter = SeasonPresenter(this)

        imgBackSeason.setOnClickListener { this.finish() }

    }

    override fun onResume() {
        super.onResume()
        rvSeason.adapter = null
        presenter.loadSeason(Utility.getSeason()?.toLowerCase(), Utility.getYear().toString())
    }

    override fun seasonLoaded(data: ArrayList<Season>) {
        val adapter = SeasonRecyclerView(this, data)
        adapter.notifyDataSetChanged()
        rvSeason.adapter = adapter
    }

}
