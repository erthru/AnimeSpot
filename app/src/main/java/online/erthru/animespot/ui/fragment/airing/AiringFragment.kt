package online.erthru.animespot.ui.fragment.airing


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_airing.view.*

import online.erthru.animespot.R
import online.erthru.animespot.Utility
import online.erthru.animespot.base.BaseFragment
import java.util.*

class AiringFragment : BaseFragment() {

    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_airing, container, false)

        v.vpAiring.adapter = AiringTabLayout(childFragmentManager)
        v.tabAiring.setupWithViewPager(v.vpAiring)

        v.tvJSTAiring.text = "Current JST : "+Utility.getCurrentJST()

        return v
    }

}
