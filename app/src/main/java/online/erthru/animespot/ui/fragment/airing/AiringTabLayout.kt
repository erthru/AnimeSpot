package online.erthru.animespot.ui.fragment.airing

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import online.erthru.animespot.ui.fragment.today.TodayFragment

import online.erthru.animespot.ui.fragment.tommorow.TomorrowFragment

class AiringTabLayout(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    private val title = arrayOf("Today","Tomorrow")

    override fun getItem(position: Int): Fragment {

        return if(position == 0){
            TodayFragment()
        }else{
            TomorrowFragment()
        }


    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return title.get(position)
    }

}