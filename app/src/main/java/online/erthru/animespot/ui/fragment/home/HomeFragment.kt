package online.erthru.animespot.ui.fragment.home


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.view.*

import online.erthru.animespot.R
import online.erthru.animespot.Utility
import online.erthru.animespot.base.BaseFragment
import online.erthru.animespot.local.SQLiteHelper
import online.erthru.animespot.ui.activity.favorites.FavoritesActivity
import online.erthru.animespot.ui.activity.nextseason.NextSeasonActivity
import online.erthru.animespot.ui.activity.season.SeasonActivity
import online.erthru.animespot.ui.activity.top.TopActivity

class HomeFragment : BaseFragment() {

    lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)

        v.tvSeasonHome.setText("This "+Utility.getSeason())
        v.tvNextSeasonHome.setText("Next "+Utility.getNextSeason())

        v.layoutThisSeasonHome.setOnClickListener { startActivity(Intent(context, SeasonActivity::class.java)) }
        v.layoutNextSeasonHome.setOnClickListener { startActivity(Intent(context, NextSeasonActivity::class.java)) }

        v.layoutFavoritesHome.setOnClickListener {
            if(SQLiteHelper(context!!).countFavorites() == 0){
                showErrorMessage("Favorites empty.")
            }else{
                startActivity(Intent(context,FavoritesActivity::class.java))
            }
        }

        v.layoutTrendingHome.setOnClickListener { startActivity(Intent(context,TopActivity::class.java)) }

        return v
    }


}
