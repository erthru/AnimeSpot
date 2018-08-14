package online.erthru.animespot.ui.activity.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import online.erthru.animespot.R
import online.erthru.animespot.Utility
import online.erthru.animespot.base.BaseActivity
import online.erthru.animespot.ui.fragment.airing.AiringFragment
import online.erthru.animespot.ui.fragment.home.HomeFragment
import online.erthru.animespot.ui.fragment.about.AboutFragment
import online.erthru.animespot.ui.activity.search.SearchActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val series = AHBottomNavigationItem("Home",R.drawable.home, R.color.colorAccent)
        val airing = AHBottomNavigationItem("Airing",R.drawable.clock, R.color.colorAccent)
        val search = AHBottomNavigationItem("Search",R.drawable.search, R.color.colorAccent)
        val setting = AHBottomNavigationItem("About",R.drawable.about, R.color.colorAccent)

        botnavMain.addItem(series)
        botnavMain.addItem(airing)
        botnavMain.addItem(search)
        botnavMain.addItem(setting)

        botnavMain.defaultBackgroundColor = resources.getColor(R.color.colorWhite)
        botnavMain.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.flHome, HomeFragment()).commit()

        botnavMain.setOnTabSelectedListener(object : AHBottomNavigation.OnTabSelectedListener{

            override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {

                when(position){

                    0 -> fm.beginTransaction().replace(R.id.flHome, HomeFragment()).commit()
                    1 -> fm.beginTransaction().replace(R.id.flHome, AiringFragment()).commit()
                    2 -> {
                        startActivity(Intent(applicationContext, SearchActivity::class.java))
                    }
                    3 -> fm.beginTransaction().replace(R.id.flHome, AboutFragment()).commit()

                }

                return true

            }

        })

    }

    override fun onResume() {
        super.onResume()
        botnavMain.setCurrentItem(0)
    }

}
