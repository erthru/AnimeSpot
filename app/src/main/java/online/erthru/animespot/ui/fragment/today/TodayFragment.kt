package online.erthru.animespot.ui.fragment.today


import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_today.view.*

import online.erthru.animespot.R
import online.erthru.animespot.base.BaseFragment
import online.erthru.animespot.network.model.Day

class TodayFragment : BaseFragment(),TodayContract.View {

    lateinit var presenter: TodayContract.Presenter
    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_today, container, false)

        v.rvToday.layoutManager = LinearLayoutManager(activity)
        v.rvToday.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        v.rvToday.adapter = null

        initProgressBar(v.pbToday)

        presenter = TodayPresenter(this)

        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.loadToday()
    }

    override fun todayLoaded(data: ArrayList<Day>?) {
        val adapter = TodayRecyclerView(this,data)
        adapter.notifyDataSetChanged()
        v.rvToday.adapter = adapter
    }


}
