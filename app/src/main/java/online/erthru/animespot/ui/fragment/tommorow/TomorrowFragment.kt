package online.erthru.animespot.ui.fragment.tommorow


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_today.view.*
import kotlinx.android.synthetic.main.fragment_tomorrow.view.*

import online.erthru.animespot.R
import online.erthru.animespot.base.BaseFragment
import online.erthru.animespot.network.model.Day
import online.erthru.animespot.ui.fragment.today.*


class TomorrowFragment : BaseFragment(),TomorrowContract.View {

    lateinit var presenter: TomorrowContract.Presenter
    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_tomorrow, container, false)

        v.rvTomorrow.layoutManager = LinearLayoutManager(activity)
        v.rvTomorrow.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        v.rvTomorrow.adapter = null

        initProgressBar(v.pbTomorrow)

        presenter = TomorrowPresenter(this)

        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.loadTomorrow()
    }


    override fun tomorrowLoaded(data: ArrayList<Day>?) {
        val adapter = TomorrowRecyclerView(this,data)
        adapter.notifyDataSetChanged()
        v.rvTomorrow.adapter = adapter
    }

}
