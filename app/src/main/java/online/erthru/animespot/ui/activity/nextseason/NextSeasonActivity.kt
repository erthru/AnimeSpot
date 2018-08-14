package online.erthru.animespot.ui.activity.nextseason

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_next_season.*
import online.erthru.animespot.R
import online.erthru.animespot.Utility
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.network.model.Season

class NextSeasonActivity : BaseActivity(),NextSeasonContract.View {

    lateinit var presenter: NextSeasonContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_season)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(R.color.colorOrangeDark)
        }

        initProgressBar(pbNextSeason)

        rvNextSeason.layoutManager = LinearLayoutManager(this)
        rvNextSeason.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        presenter = NextSeasonPresenter(this)

        imgBackNextSeason.setOnClickListener { this.finish() }

    }

    override fun onResume() {
        super.onResume()
        rvNextSeason.adapter = null
        presenter.loadSeason(Utility.getNextSeason()?.toLowerCase(),Utility.getYear().toString())
    }

    override fun seasonLoaded(data: ArrayList<Season>?) {
        val adapter = NextSeasonRecyclerView(this,data)
        adapter.notifyDataSetChanged()
        rvNextSeason.adapter = adapter
    }

}
