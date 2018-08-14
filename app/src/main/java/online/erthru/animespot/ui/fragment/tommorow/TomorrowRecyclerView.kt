package online.erthru.animespot.ui.fragment.today

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_today.view.*
import kotlinx.android.synthetic.main.list_tomorrow.view.*
import online.erthru.animespot.R
import online.erthru.animespot.network.model.Day
import online.erthru.animespot.ui.activity.anime.AnimeActivity
import online.erthru.animespot.ui.fragment.tommorow.TomorrowFragment
import java.lang.StringBuilder

class TomorrowRecyclerView(val context: TomorrowFragment, val arrayList: ArrayList<Day>?) : RecyclerView.Adapter<TomorrowRecyclerView.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_tomorrow,parent,false))
    }

    override fun getItemCount(): Int = arrayList?.size ?:0

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val tomorrow = arrayList?.get(position)
        holder.v.tvTitleLTomorrow.text = tomorrow?.title
        val timeReverse = StringBuilder(tomorrow?.airing_start).reverse().substring(0,10)
        val timeFix = StringBuilder(timeReverse).reverse()
        if(!timeFix.contains("JST")){
            holder.v.tvTimeLTomorrow.text = "Time: Unknown"
        }else{
            holder.v.tvTimeLTomorrow.text = "Time: "+timeFix
        }
        Glide.with(context).load(tomorrow?.image_url).into(holder.v.imgLTomorrow)

        holder.v.setOnClickListener {
            val i = Intent(context.activity,AnimeActivity::class.java)
            i.putExtra("id",tomorrow?.mal_id.toString())
            context.startActivity(i)
        }

    }


    class Holder(val v:View) : RecyclerView.ViewHolder(v)

}